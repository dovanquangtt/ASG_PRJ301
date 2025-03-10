/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Course;

/**
 *
 * @author admin
 */
public class CourseDAO extends DBContext {

    public List<Course> getAll() {
        List<Course> list = new ArrayList<>();
        String sql = "select * from tblCourses";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getString(1));
                c.setName(rs.getString(2));
                c.setDescription(rs.getString(3));
                c.setDuration(rs.getInt(4));
                c.setFee(rs.getInt(5));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Course getCourseByID(String id) {
        String sql = "select * from [tblCourses] \n"
                + "WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setName(rs.getString(1));
                course.setDescription(rs.getString(2));
                course.setDuration(rs.getInt(3));
                course.setFee(rs.getDouble(4));
                course.setId(rs.getString(5));
                return course;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCourse(Course course) {
        String sql = " INSERT INTO [dbo].[tblCourses]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[description]\n"
                + "           ,[duration]\n"
                + "           ,[fee])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)USE [CourseManagement] ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, course.getId());
            ps.setString(2, course.getName());
            ps.setString(3, course.getDescription());
            ps.setInt(4, course.getDuration());
            ps.setDouble(5, course.getFee());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateCourse(Course course) {
        String sql = "UPDATE [dbo].[tblCourses]\n"
                + "   SET [name] = <name, nvarchar(100),>\n"
                + "      ,[description] = <description, nvarchar(500),>\n"
                + "      ,[duration] = <duration, int,>\n"
                + "      ,[fee] = <fee, float,>\n"
                + " WHERE [id] = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, course.getId());
            ps.setString(1, course.getName());
            ps.setString(1, course.getDescription());
            ps.setInt(1, course.getDuration());
            ps.setDouble(1, course.getFee());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteCourse(String id) {
        String sql = "DELETE FROM [dbo].[tblCourses]\n"
                + "      WHERE [id] = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
