/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Request;
import java.sql.*;

/**
 *
 * @author admin
 */
public class RequestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RequestController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RequestController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");
            return;
        }

        // Lấy dữ liệu từ form
        String dateFromParam = request.getParameter("startDate");
        String dateToParam = request.getParameter("endDate");
        String reason = request.getParameter("reason");

        List<String> error = new ArrayList<>();

        // Kiểm tra rỗng
        if (dateFromParam == null || dateFromParam.trim().isEmpty()
                || dateToParam == null || dateToParam.trim().isEmpty()
                || reason == null || reason.trim().isEmpty()) {
            error.add("Vui lòng điền đầy đủ thông tin.");
        }

        // Khai báo biến Date
        Date dateFrom = null;
        Date dateTo = null;
        Date now = Date.valueOf(LocalDate.now());

        // Kiểm tra định dạng ngày
        if (error.isEmpty()) {
            try {
                dateFrom = Date.valueOf(dateFromParam);
            } catch (IllegalArgumentException e) {
                error.add("Ngày bắt đầu nghỉ không hợp lệ. (Định dạng: yyyy-MM-dd)");
            }

            try {
                dateTo = Date.valueOf(dateToParam);
            } catch (IllegalArgumentException e) {
                error.add("Ngày kết thúc nghỉ không hợp lệ. (Định dạng: yyyy-MM-dd)");
            }
        }

        // Kiểm tra logic ngày
        if (error.isEmpty()) {
            if (dateFrom.after(dateTo)) {
                error.add("Ngày bắt đầu nghỉ không thể sau ngày kết thúc nghỉ.");
            }
            if (dateTo.before(now)) {
                error.add("Ngày kết thúc nghỉ không thể là quá khứ.");
            }
            if (dateFrom.before(now)) {
                error.add("Ngày bắt đầu nghỉ không thể là quá khứ.");
            }
        }

        // Nếu có lỗi, chuyển về form nhập
        if (!error.isEmpty()) {
            request.setAttribute("error", error);
            if (account.getRoleId() == 2) { // Manager
                request.getRequestDispatcher("manager.jsp?action=create").forward(request, response);
            } else { // Employee
                request.getRequestDispatcher("createForm.jsp").forward(request, response);
            }
            return;
        }

        // Nếu không có lỗi, lưu vào database
        RequestDAO requestdao = new RequestDAO();
        Request re = new Request(0, account.getEmployeeId(), dateTo, dateFrom, now, reason, "Pending");
        requestdao.insert(re);

        request.setAttribute("message", "Submit successfully");

        // Điều hướng về trang tương ứng
        if (account.getRoleId() == 2) { // Manager
            request.getRequestDispatcher("manager.jsp?action=create").forward(request, response);
        } else {
            request.getRequestDispatcher("createForm.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
