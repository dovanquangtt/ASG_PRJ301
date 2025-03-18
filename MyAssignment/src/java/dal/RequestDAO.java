/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.Request;

/**
 *
 * @author admin
 */
public class RequestDAO extends DBContext {

    public List<Request> getRequestByManagerID(int managerId) {
        List<Request> requests = new ArrayList<>();
        String sql = "select r.DateCreate,r.DateFrom,r.DateTo,r.Reason,r.Status,e.Id,e.Name \n"
                + "from Request r \n"
                + "inner join Employee  e on r.EmployeeId = e.Id \n"
                + "where e.Parentemployee = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, managerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Request request = new Request();
                request.setDateCreate(rs.getDate(1));
                request.setDateFrom(rs.getDate(2));
                request.setDateTo(rs.getDate(3));
                request.setReason(rs.getString(4));
                request.setStatus(rs.getString(5));
                request.setEmployeeId(rs.getInt("Id")); // Employee ID
                requests.add(request);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
    }

    public Request getRequestbyId(int Id) {
        Request r = null;
        String sql = "select r.Id,r.DateCreate,r.DateFrom,r.DateTo,r.Reason,r.Status from Request r where r.Id=?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, Id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                r = new Request();
                r.setId(rs.getInt("Id"));
                r.setDateCreate(rs.getDate("DateCreate"));
                r.setDateFrom(rs.getDate("DateFrom"));
                r.setDateTo(rs.getDate("DateTo"));
                r.setReason(rs.getString("Reason"));
                r.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public int insert(Request request) {
        int result = -1;
        String sql = "INSERT INTO [dbo].[Request] ( [EmployeeId], [DateTo], [DateFrom], [DateCreate], [Reason], [Status]) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        // Sử dụng try-with-resources để tự động đóng PreparedStatement
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, request.getEmployeeId());
            st.setDate(2, request.getDateTo());
            st.setDate(3, request.getDateFrom());
            st.setDate(4, request.getDateCreate());
            st.setString(5, request.getReason()); // Nếu đổi tên thuộc tính, thì đây thành getReason()
            st.setString(6, request.getStatus());
            result = st.executeUpdate();
        } catch (SQLException ex) {
            // Log lỗi để tiện debug
            ex.printStackTrace();
        }
        return result;
    }

    public int updateSatatusRequest(Request request) {
        int result = -1;
        String sql = "update Request SET DateFrom = ? , DateTo = ?, Reason = ? where  Id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, request.getDateFrom());
            ps.setDate(2, request.getDateTo());
            ps.setString(3, request.getReason());
            ps.setInt(4, request.getId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Request> getRequestByEmployeeId(int employeeId) {
        List<Request> list = new ArrayList<>();
        String sql = "select r.Id, r.DateCreate,r.DateFrom,r.DateTo,r.Reason,r.Status from Request r where r.EmployeeId= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, employeeId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request requests = new Request();
                requests.setId(rs.getInt(1));
                requests.setDateCreate(rs.getDate(2));
                requests.setDateFrom(rs.getDate(3));
                requests.setDateTo(rs.getDate(4));
                requests.setReason(rs.getString(5));
                requests.setStatus(rs.getString(6));
                list.add(requests);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int DeleteRequest(int id) {
        int Result = -1;
        String sql = "DELETE FROM [dbo].[Request]\n"
                + "      WHERE Id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            Result = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result;
    }

//    public static void main(String[] args) {
//        RequestDAO dao = new RequestDAO();
//
//        // Giả sử bạn muốn test với Id = 1
//        int testId = 52;
//        Request result = dao.getRequestbyId(testId);
//
//        if (result != null) {
//            System.out.println("Đã tìm thấy request với Id = " + testId);
//            System.out.println("Chi tiết request: " + result.toString());
//        } else {
//            System.out.println("Không tìm thấy request với Id = " + testId);
//        }
//    }
    public static void main(String[] args) {
        // Bước 1: Chuẩn bị đối tượng Request
        Request request = new Request();
        request.setId(1); // Thay bằng ID hợp lệ trong cơ sở dữ liệu của bạn
        request.setDateFrom(Date.valueOf("2023-10-01")); // Ngày bắt đầu
        request.setDateTo(Date.valueOf("2023-10-05")); // Ngày kết thúc
        request.setReason("Cập nhật lý do mới"); // Lý do mới

        // Bước 2: Tạo đối tượng RequestDAO và gọi hàm updateSatatusRequest
        RequestDAO dao = new RequestDAO();
        int result = dao.updateSatatusRequest(request);

        // Bước 3: Kiểm tra kết quả
        if (result == -1) {
            System.out.println("Cập nhật không thành công hoặc có lỗi xảy ra.");
        } else {
            System.out.println("Cập nhật thành công. Số hàng ảnh hưởng: " + result);
        }
    }

}
