package com.hds.model;

import javax.persistence.*;

@Entity
@Table(name = "ProductOrderItem")
public class ProductOrderItemPojo {

    @Id
    @Column(name = "ItemID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;

    @Column(name = "ProductID")
    private int product_id;

    @Column(name = "OrderID")
    private int order_id;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Cost")
    private double cost;

    @Column(name = "ExtCost")
    private double ext_cost;


    // Getter Setter methods


    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getExt_cost() {
        return ext_cost;
    }

    public void setExt_cost(double ext_cost) {
        this.ext_cost = ext_cost;
    }
}
