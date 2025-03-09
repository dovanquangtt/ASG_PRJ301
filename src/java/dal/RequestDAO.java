/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Request;

/**
 *
 * @author admin
 */
public class RequestDAO extends DBContext {

    public List<Request> getAllRequests() {
        List<Request> list = new ArrayList<>();
        String sql = "select * from Request ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Request rq = new Request();
                rq.setId(rs.getInt(1));
                rq.setEmployeeId(rs.getInt(2));
                rq.setDateFrom(rs.getString(3));
                rq.setDateto(rs.getString(4));
                rq.setReason(rs.getString(5));
                rq.setStatus(rs.getString(6));
                list.add(rq);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addRequest(Request request) {
        String sql = "INSERT INTO [dbo].[Request]\n"
                + "           ([Id]\n"
                + "           ,[EmployeeId]\n"
                + "           ,[DateTo]\n"
                + "           ,[DateFrom]\n"
                + "           ,[DateCreate]\n"
                + "           ,[Reason]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, request.getId());
            ps.setInt(2, request.getEmployeeId());
            ps.setString(3, request.getDateto());
            ps.setString(4, request.getDateFrom());
            ps.setString(5, request.getDateCreate());
            ps.setString(6, request.getReason());
            ps.setString(7, request.getStatus());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateRequest(Request request) {
        String sql = " UPDATE [dbo].[Request]\n"
                + "   SET [EmployeeId] = ?\n"
                + "      ,[DateTo] = ?\n"
                + "      ,[DateFrom] = ?\n"
                + "      ,[DateCreate] = ?\n"
                + "      ,[Reason] = ?\n"
                + "      ,[Status] = ?\n"
                + " WHERE [Id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, request.getEmployeeId());
            ps.setString(2, request.getDateto());
            ps.setString(3, request.getDateFrom());
            ps.setString(4, request.getDateCreate());
            ps.setString(5, request.getReason());
            ps.setString(6, request.getStatus());
            ps.setInt(7, request.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRequest(int id) {
        String sql = " DELETE FROM [dbo].[Request]\n"
                + " WHERE [Id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
