/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author admin
 */
public class AccountDAO extends DBContext {

    public Account validateUser(String username, String password) {
        String sql = "select * from Account "
                + "where Username = ? AND Password = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                list.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return list;
    }

    public Account getAccountById(int id) {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.getId();
                account.getUsername();
                account.getPassword();
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return null;
    }

    public void addAccount(Account account) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([Id]\n"
                + "           ,[Username]\n"
                + "           ,[Password])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, account.getId());
            ps.setString(2, account.getUsername());
            ps.setString(3, account.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    public void updateAccount(Account account) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [Username] = ?\n"
                + "      ,[Password] = ?\n"
                + " WHERE  [Id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    public void deleteAccount(int id) {
        String sql = "DELETE FROM [dbo].[Account]\n"
                + "      WHERE [Id] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

}
