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
        Account acc = (Account) session.getAttribute("account");

        // Nếu chưa đăng nhập, chuyển hướng về trang login
        if (acc == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Lấy dữ liệu từ form
        String dateFrom = request.getParameter("startDate");
        String dateTo = request.getParameter("endDate");
        String reason = request.getParameter("reason");

        // Danh sách lỗi
        List<String> errors = new ArrayList<>();

        // Kiểm tra dữ liệu đầu vào rỗng
        if (dateFrom == null || dateTo == null || dateFrom.isEmpty() || dateTo.isEmpty() || reason.trim().isEmpty()) {
            errors.add("Vui lòng điền đầy đủ thông tin.");
        }

        Date from = null;
        Date to = null;
        Date now = Date.valueOf(LocalDate.now());

        // Chỉ xử lý logic ngày nếu không có lỗi input rỗng
        if (errors.isEmpty()) {
            try {
                from = Date.valueOf(dateFrom);
                to = Date.valueOf(dateTo);

                // Kiểm tra logic ngày
                if (from.after(to)) {
                    errors.add("Ngày bắt đầu không thể sau ngày kết thúc.");
                }
                if (from.equals(to)) {
                    errors.add("Ngày bắt đầu và ngày kết thúc không thể giống nhau.");
                }
                if (from.before(now)) {
                    errors.add("Ngày bắt đầu không thể là quá khứ.");
                }
                if (to.before(now)) {
                    errors.add("Ngày kết thúc không thể là quá khứ.");
                }

            } catch (IllegalArgumentException e) {
                errors.add("Định dạng ngày không hợp lệ.");
            }
        }

        // Nếu không có lỗi, tiến hành insert vào database
        if (errors.isEmpty()) {
            RequestDAO requestDAO = new RequestDAO();
            Request requestObj = new Request(0, acc.getEmployeeId(), to, from, now, reason, "Pending");

            try {
                // Gửi đơn và kiểm tra kết quả
                boolean isInserted = requestDAO.insertRequest(requestObj); // Giả sử phương thức trả về boolean
                if (isInserted) {
                    request.setAttribute("message", "Gửi đơn thành công!");
                } else {
                    errors.add("Gửi đơn thất bại do lỗi hệ thống.");
                }
            } catch (Exception e) {
                errors.add("Gửi đơn thất bại do lỗi hệ thống: " + e.getMessage());
                e.printStackTrace(); // In lỗi ra console để debug
            }
        }

        // Gửi danh sách lỗi về JSP (nếu có)
        if (!errors.isEmpty()) {
            request.setAttribute("error", errors);
        }

        // Phân quyền chuyển hướng: Employee hoặc Manager
        String targetPage = acc.getRoleId() == 3 ? "employee.jsp" : "manager.jsp";
        if (acc.getRoleId() != 3 && acc.getRoleId() != 2) {
            targetPage = "error.jsp"; // Nếu role không hợp lệ
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
