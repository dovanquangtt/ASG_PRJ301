/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import model.Users;

/**
 *
 * @author admin
 */
public class UsersDAO extends DBContext {

    public Users validateUser(String userID, String password) {
        String sql = "select * from tblUsers \n"
                + "where userID = ? AND password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users tb = new Users();
                tb.setUserID(rs.getString(1));
                tb.setPassword(rs.getString(2));
                tb.setFullName(rs.getString(3));
                return tb;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

}
