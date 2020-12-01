package com.hds.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Order")
public class OrderPojo {

    @Id
    @Column(name = "OrderID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @Column(name = "CustomerID")
    private int customer_id;

    @Column(name = "AddressID")
    private int address_id;

    @Column(name = "ShippingCost")
    private double shipping_cost;

    @Column(name = "TotalCost")
    private double total_cost;

    @Column(name = "DateOrdered")
    private LocalDate date_ordered;

    @Column(name = "DateDelivered")
    private LocalDate date_delivered;

    private String street;

    private String city;

    private String state;

    private int zip;

    private String firstName;

    private String lastName;

    private int productID;


    private String productName;

    private String modelNum;

    private int serialNum;

    private String description;

    private int listPrice;

    private int quantity;

    private int exactCost;


    // Getter Setter methods


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public double getShipping_cost() {
        return shipping_cost;
    }

    public void setShipping_cost(double shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public LocalDate getDate_ordered() {
        return date_ordered;
    }

    public void setDate_ordered(LocalDate date_ordered) {
        this.date_ordered = date_ordered;
    }

    public LocalDate getDate_delivered() {
        return date_delivered;
    }

    public void setDate_delivered(LocalDate date_delivered) {
        this.date_delivered = date_delivered;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getZip()
    {
        return zip;
    }

    public void setZip(int zip)
    {
        this.zip = zip;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getProductID()
    {
        return productID;
    }

    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getModelNum()
    {
        return modelNum;
    }

    public void setModelNum(String modelNum)
    {
        this.modelNum = modelNum;
    }

    public int getSerialNum()
    {
        return serialNum;
    }

    public void setSerialNum(int serialNum)
    {
        this.serialNum = serialNum;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getListPrice()
    {
        return listPrice;
    }

    public void setListPrice(int listPrice)
    {
        this.listPrice = listPrice;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getExactCost()
    {
        return exactCost;
    }

    public void setExactCost(int exactCost)
    {
        this.exactCost = exactCost;
    }
}
