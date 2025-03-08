/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Role;

/**
 *
 * @author admin
 */
public class RoleDAO extends DBContext {

    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();
        String sql = "select * from Role";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));
                r.setDescription(rs.getString(3));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addRole(Role role) {
        String sql = "INSERT INTO [dbo].[Role]\n"
                + "           ([Id]\n"
                + "           ,[Name]\n"
                + "           ,[Description])\n"
                + "     VALUES\n"
                + "           (?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, role.getId());
            ps.setString(2, role.getName());
            ps.setString(3, role.getDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRole(Role role) {
        String sql = " UPDATE [dbo].[Role]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Description] = ?\n"
                + " WHERE [Id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, role.getName());
            ps.setString(2, role.getDescription());
            ps.setInt(3, role.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRole(int id) {
        String sql = "DELETE FROM [dbo].[Role]\n"
                + "      WHERE Id = ?  ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
