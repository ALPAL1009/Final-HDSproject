package com.hds.model;

import javax.persistence.*;

@Entity
@Table(name = "OfficeLocation")
public class OfficeLocationPojo {

    @Id
    @Column(name = "LocationID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;

    @Column(name = "AddressID")
    private int address_id;

    @Column(name = "Name")
    private String name;

    @Column(name = "EmployeeCount")
    private int employee_count;


    // Getter Setter methods


    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployee_count() {
        return employee_count;
    }

    public void setEmployee_count(int employee_count) {
        this.employee_count = employee_count;
    }
}
