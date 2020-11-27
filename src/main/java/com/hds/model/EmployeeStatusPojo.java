package com.hds.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeStatus")
public class EmployeeStatusPojo {

    @Id
    @Column(name = "StatusID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_id;

    @Column(name = "IsActive")
    private boolean is_active;

    @Column(name = "DateStart")
    private Date date_start;

    @Column(name = "DateEnd")
    private Date date_end;


    // Getter Setter methods


    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }
}
