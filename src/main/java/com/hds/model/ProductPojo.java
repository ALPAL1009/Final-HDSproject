package com.hds.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductPojo {

    @Id
    @Column(name = "ProductID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    @Column(name = "BrandID")
    private int brand_id;

    private String brandName;

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    @Column(name = "CategoryID")
    private int category_id;

    private String categoryName;

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    @Column(name = "InventoryCount")
    private int inventory_count;

    @Column(name = "ModelNum")
    private String model_num;

    @Column(name = "SerialNum")
    private int serial_num;

    @Column(name = "Description")
    private String description;

    @Column(name = "Cost")
    private double cost;

    @Column(name = "ListPrice")
    private double list_price;

    private int deliveryCost;

    public int getDeliveryCost()
    {
        return deliveryCost;
    }

    public void setDeliveryCost(int deliveryCost)
    {
        this.deliveryCost = deliveryCost;
    }

    @Column(name = "IsActive")
    private String is_active;


    // Getter Setter methods


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getInventory_count() {
        return inventory_count;
    }

    public void setInventory_count(int inventory_count) {
        this.inventory_count = inventory_count;
    }

    public String getModel_num() {
        return model_num;
    }

    public void setModel_num(String model_num) {
        this.model_num = model_num;
    }

    public int getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getList_price() {
        return list_price;
    }

    public void setList_price(double list_price) {
        this.list_price = list_price;
    }

    public String getIs_active()
    {
        return is_active;
    }

    public void setIs_active(String is_active)
    {
        this.is_active = is_active;
    }
}
