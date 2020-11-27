package com.hds.model;

import javax.persistence.*;

@Entity
@Table(name = "ProductBrand")
public class ProductBrandPojo {

    @Id
    @Column(name = "BrandID")
    private int brand_id;

    @Column(name = "AddressID")
    private int address_id;

    @Column(name = "ProductName")
    private String product_name;

    @Column(name = "IsActive")
    private boolean is_active;

    @Column(name = "PhoneNumber")
    private String phone_number;

    @Column(name = "Email")
    private String email;


    // Getter Setter methods


    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
