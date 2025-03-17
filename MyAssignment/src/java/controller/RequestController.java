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
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
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

        String dateFrom = request.getParameter("startDate");
        String dateTo = request.getParameter("endDate");
        String reason = request.getParameter("reason");
        List<String> error = new ArrayList<>();

        // Check for empty or null inputs
        if (dateFrom == null || dateFrom.trim().isEmpty()) {
            error.add("Vui lòng nhập ngày bắt đầu.");
        }
        if (dateTo == null || dateTo.trim().isEmpty()) {
            error.add("Vui lòng nhập ngày kết thúc.");
        }
        if (reason == null || reason.trim().isEmpty()) {
            error.add("Vui lòng nhập lý do nghỉ phép.");
        }

        if (!error.isEmpty()) {
            request.setAttribute("error", error);
            request.setAttribute("startDate", dateFrom);
            request.setAttribute("endDate", dateTo);
            request.setAttribute("reason", reason);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response); // Ensure correct JSP path
            return;
        }

        try {
            Date dateFromSql = Date.valueOf(dateFrom);
            Date dateToSql = Date.valueOf(dateTo);
            Date now = Date.valueOf(LocalDate.now());

            // Additional validations
            if (dateFromSql.after(dateToSql)) {
                error.add("Ngày bắt đầu không thể sau ngày kết thúc.");
            }
            if (dateToSql.before(now)) {
                error.add("Ngày kết thúc không thể là quá khứ.");
            }
            if (dateFromSql.before(now)) {
                error.add("Ngày bắt đầu không thể là quá khứ.");
            }

            if (!error.isEmpty()) {
                request.setAttribute("error", error);
                request.setAttribute("startDate", dateFrom);
                request.setAttribute("endDate", dateTo);
                request.setAttribute("reason", reason);
                request.getRequestDispatcher("/welcome.jsp").forward(request, response);
                return;
            }

            // Insert to database
            RequestDAO requestDAO = new RequestDAO();
            Request re = new Request(0, account.getEmployeeId(), dateToSql, dateFromSql, now, reason, "Pending");
            int result = requestDAO.insert(re);

            if (result > 0) {
                request.setAttribute("message", "Đơn nghỉ phép đã được gửi thành công!");
            } else {
                error.add("Có lỗi xảy ra khi gửi đơn. Vui lòng thử lại.");
                request.setAttribute("error", error);
            }

        } catch (IllegalArgumentException e) {
            error.add("Định dạng ngày không hợp lệ.");
            request.setAttribute("error", error);
        }

        // Always forward to welcome.jsp after processing
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);

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
