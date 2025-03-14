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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import java.sql.*;
import java.sql.Date;
import model.Account;
import model.Request;

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
        processRequest(request, response);
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
            response.sendRedirect("login.jsp");
            return;
        }

        // Lấy vai trò của người dùng từ session để xác định trang đích phù hợp
        String role = (String) session.getAttribute("role");
        String targetPage;

        if ("employee".equals(role)) {
            targetPage = "employee.jsp";
        } else if ("manager".equals(role)) {
            targetPage = "manager.jsp";
        } else {
            targetPage = "login.jsp";
        }

        String dateFrom = request.getParameter("startDate");
        String dateTo = request.getParameter("endDate");
        String reason = request.getParameter("reason");

        List<String> errors = new ArrayList<>();
        if (dateFrom == null || dateTo == null || reason == null || reason.trim().isEmpty()) {
            errors.add("Dữ liệu không hợp lệ, vui lòng nhập lại.");
        }

        try {
            Date from = Date.valueOf(dateFrom);
            Date to = Date.valueOf(dateTo);
            Date now = Date.valueOf(LocalDate.now());

            if (from.after(to)) {
                errors.add("Ngày bắt đầu không thể sau ngày kết thúc.");
            }
            if (to.before(now)) {
                errors.add("Ngày kết thúc không thể là quá khứ.");
            }
            if (from.before(now)) {
                errors.add("Ngày bắt đầu không thể là quá khứ.");
            }

            // Nếu không có lỗi, tiến hành thêm yêu cầu vào cơ sở dữ liệu
            if (errors.isEmpty()) {
                RequestDAO requestDAO = new RequestDAO();
                Request requestObj = new Request(
                        account.getEmployeeId(),
                        to, from, now,
                        reason,
                        "Pending"
                );

                // Thực hiện thêm yêu cầu vào cơ sở dữ liệu và kiểm tra kết quả
                boolean success = requestDAO.insertRequest(requestObj);
                if (success) {
                    request.setAttribute("message", "Gửi đơn thành công!");
                } else {
                    request.setAttribute("message", "Gửi đơn thất bại!");
                }
            } else {
                request.setAttribute("error", errors);
            }
        } catch (IllegalArgumentException e) {
            errors.add("Định dạng ngày không hợp lệ.");
            request.setAttribute("error", errors);
        }

        request.getRequestDispatcher(targetPage).forward(request, response);

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
