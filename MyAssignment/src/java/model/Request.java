/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

/**
 *
 * @author admin
 */
public class Request {

    private Integer id;
    private int employeeId;
    private Date dateTo;
    private Date DateFrom;
    private Date dateCreate;
    private String reason;
    private String Status;

    public Request() {
    }

    public Request(Integer id, int employeeId, Date dateTo, Date DateFrom, Date dateCreate, String reason, String Status) {
        this.id = id;
        this.employeeId = employeeId;
        this.dateTo = dateTo;
        this.DateFrom = DateFrom;
        this.dateCreate = dateCreate;
        this.reason = reason;
        this.Status = Status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date DateFrom) {
        this.DateFrom = DateFrom;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Request{" + "id=" + id + ", employeeId=" + employeeId + ", dateTo=" + dateTo + ", DateFrom=" + DateFrom + ", dateCreate=" + dateCreate + ", reason=" + reason + ", Status=" + Status + '}';
    }

   
   
}
