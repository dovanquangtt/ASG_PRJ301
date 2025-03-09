/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author admin
 */
public class EmployeeDAO extends DBContext {

    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        String sql = "select * from Employee";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee ep = new Employee();
                ep.setId(rs.getInt(1));
                ep.setTen(rs.getString(2));
                ep.setDob(rs.getString(3));
                ep.setEmail(rs.getString(4));
                ep.setPhone(rs.getString(5));
                ep.setDivisionId(rs.getInt(6));
                ep.setRoleId(rs.getInt(7));
                list.add(ep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Employee getEmployedID(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setTen(rs.getString(2));
                employee.setDob(rs.getString(3));
                employee.setEmail(rs.getString(4));
                employee.setPhone(rs.getString(4));
                employee.setDivisionId(rs.getInt(5));
                employee.setRoleId(rs.getInt(6));
                employee.setId(rs.getInt(7));
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO [dbo].[Employee]\n"
                + "           ([Id]\n"
                + "           ,[Ten]\n"
                + "           ,[Dob]\n"
                + "           ,[Email]\n"
                + "           ,[Phone]\n"
                + "           ,[DivisionId]\n"
                + "           ,[RoleId])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, employee.getId());
            st.setString(2, employee.getTen());
            st.setString(3, employee.getDob());
            st.setString(4, employee.getEmail());
            st.setString(5, employee.getPhone());
            st.setInt(6, employee.getDivisionId());
            st.setInt(7, employee.getRoleId());
            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateEmployee(Employee employee) {
        String sql = "UPDATE [dbo].[Employee]\n"
                + "   SET [Ten] = ?,[Dob] = ?,[Email] = ?,[Phone] = ?,[DivisionId] = ?,[RoleId] = ?\n"
                + " WHERE  [Id] = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getTen());
            ps.setString(3, employee.getDob());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPhone());
            ps.setInt(6, employee.getDivisionId());
            ps.setInt(7, employee.getRoleId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteEmployee(int id) {
        String sql = "DELETE FROM [dbo].[Employee]\n"
                + "      WHERE Id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
