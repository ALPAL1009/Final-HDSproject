package com.hds.model;

import javax.persistence.*;

@Entity
@Table(name = "EmployeeSiteUser")
public class EmployeeSiteUserPojo {

    @Id
    @Column(name = "SiteUserID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int site_user_id;

    @Column(name = "EmployeeID")
    private int employee_id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "IsAdmin")
    private boolean is_admin;


    // Getter Setter methods


    public int getSite_user_id() {
        return site_user_id;
    }

    public void setSite_user_id(int site_user_id) {
        this.site_user_id = site_user_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
