/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Schedule;

/**
 *
 * @author admin
 */
public class ScheduleDAO extends DBContext {

    public List<Schedule> getSchedule() {
        List<Schedule> list = new ArrayList<>();
        String sql = "select  sche.Id,sche.Date,sche.Status,e.Name \n"
                + "from Schedule sche \n"
                + "inner join Employee e on e.Id = sche.EmployeeId";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Schedule sc = new Schedule();
                sc.setId(rs.getInt(1));
                sc.setDate(rs.getDate(2));
                sc.setStatus(rs.getString(3));
                //Tên nhân viên được lấy nhưng không lưu trữ trong mô hình lịch trình
                list.add(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Schedule> getScheduleByManagerId(int managerId) {
        List<Schedule> schedule = new ArrayList<>();
        String sql = " select  sche.Id,sche.Date,sche.Status,e.Name \n"
                + "from Schedule sche \n"
                + "inner join Employee e on e.Id = sche.EmployeeId\n"
                + "where e.Parentemployee = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, managerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule sch = new Schedule();
                sch.setId(rs.getInt(1));
                sch.setDate(rs.getDate(2));
                sch.setStatus(rs.getString(3));
                //Tên nhân viên được lấy nhưng không lưu trữ trong mô hình lịch trình
                schedule.add(sch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schedule;

    }

}
