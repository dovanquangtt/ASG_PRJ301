/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
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

    public boolean insertRequest(Request request) {
        String sql = "INSERT INTO Request (EmployeeId, DateTo, DateFrom, DateCreate, Reason, Status) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
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
        return false;
    }

    public boolean updateSatatusRequest(int employeeId, String status) {
        String sql = "update Request SET  Status = '?' where  EmployeeId = ? ";
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

}
