/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Request {

    private int Id;
    private int EmployeeId;
    private String DateFrom;
    private String Dateto;
    private String DateCreate;
    private String Reason;
    private String Status;

    public Request() {
    }

    public Request(int Id, int EmployeeId, String DateFrom, String Dateto, String DateCreate, String Reason, String Status) {
        this.Id = Id;
        this.EmployeeId = EmployeeId;
        this.DateFrom = DateFrom;
        this.Dateto = Dateto;
        this.DateCreate = DateCreate;
        this.Reason = Reason;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(String DateFrom) {
        this.DateFrom = DateFrom;
    }

    public String getDateto() {
        return Dateto;
    }

    public void setDateto(String Dateto) {
        this.Dateto = Dateto;
    }

    public String getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(String DateCreate) {
        this.DateCreate = DateCreate;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
