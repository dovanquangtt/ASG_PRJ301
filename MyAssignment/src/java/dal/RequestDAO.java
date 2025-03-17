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

    public List<Request> getReuestbyId(int Id) {
        List<Request> list = new ArrayList<>();
        String sql = "select r.Id,r.DateCreate,r.DateFrom,r.DateTo,r.Reason,r.Status from Request r where r.EmployeeId=?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, Id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request r = new Request();
                r.setId(rs.getInt("Id"));
                r.setDateTo(rs.getDate("DateTo"));
                r.setDateFrom(rs.getDate("DateFrom"));
                r.setDateCreate(rs.getDate("DateCreate"));
                r.setReason(rs.getString("Reason"));
                r.setStatus(rs.getString("Status"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertRequest(Request request) {
        String sql = "INSERT INTO Request (EmployeeId, DateTo, DateFrom, DateCreate, Reason, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, request.getEmployeeId());
            ps.setDate(2, request.getDateTo());
            ps.setDate(3, request.getDateFrom());
            ps.setDate(4, request.getDateCreate());
            ps.setString(5, request.getReason());
            ps.setString(6, request.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateSatatusRequest(int employeeId, String status) {
        String sql = "update Request SET  Status = ? where  EmployeeId = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, employeeId);
            int rowUpdate = ps.executeUpdate();
            return rowUpdate > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Request> getRequestByEmployeeId(int employeeId) {
        List<Request> list = new ArrayList<>();
        String sql = "select r.DateCreate,r.DateFrom,r.DateTo,r.Reason,r.Status from Request r where r.EmployeeId= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, employeeId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Request requests = new Request();
                requests.setDateCreate(rs.getDate(1));
                requests.setDateFrom(rs.getDate(2));
                requests.setDateTo(rs.getDate(3));
                requests.setReason(rs.getString(4));
                requests.setStatus(rs.getString(5));
                requests.setEmployeeId(employeeId);  // gán employeeId vào đối tượng request
                list.add(requests);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        RequestDAO dao = new RequestDAO();

        // Dữ liệu giả để test
        int employeeId = 2;
        Date from = Date.valueOf("2025-03-17");
        Date to = Date.valueOf("2025-03-17");
        Date createDate = Date.valueOf(LocalDate.now());
        String reason = "abc";
        String status = "Pending";

        // Tạo một Request object
        Request request = new Request(0, employeeId, to, from, createDate, reason, status);

        // Gọi hàm insertRequest
        dao.insertRequest(request);

        System.out.println("Insert thành công!");
    }

}
