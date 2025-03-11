/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Employee {

    private int id;
    private String ten;
    private Date dob;
    private int ParentEmployee;

    public Employee() {
    }

    public Employee(int id, String ten, Date dob, int ParentEmployee) {
        this.id = id;
        this.ten = ten;
        this.dob = dob;
        this.ParentEmployee = ParentEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getParentEmployee() {
        return ParentEmployee;
    }

    public void setParentEmployee(int ParentEmployee) {
        this.ParentEmployee = ParentEmployee;
    }

}
