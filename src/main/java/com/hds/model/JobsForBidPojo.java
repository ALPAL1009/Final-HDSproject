package com.hds.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "JobsForBid")
public class JobsForBidPojo {

    @Id
    @Column(name = "JobBidID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int job_bid_id;

    @Column(name = "Description")
    private String description;

    @Column(name = "BidAmt")
    private double bid_amount;

    @Column(name = "DateOpen")
    private LocalDate date_open;

    @Column(name = "DateClosed")
    private LocalDate date_closed;

    private String street;

    private String city;

    private String state;

    private int zip;

    public JobsForBidPojo()
    {
    }

    public JobsForBidPojo(int job_bid_id, String description, double bid_amount, LocalDate date_open, LocalDate date_closed)
    {
        this.job_bid_id = job_bid_id;
        this.description = description;
        this.bid_amount = bid_amount;
        this.date_open = date_open;
        this.date_closed = date_closed;
    }

    // Getter Setter methods


    public int getJob_bid_id() {
        return job_bid_id;
    }

    public void setJob_bid_id(int job_bid_id) {
        this.job_bid_id = job_bid_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBid_amount() {
        return bid_amount;
    }

    public void setBid_amount(double bid_amount) {
        this.bid_amount = bid_amount;
    }

    public LocalDate getDate_open() {
        return date_open;
    }

    public void setDate_open(LocalDate date_open) {
        this.date_open = date_open;
    }

    public LocalDate getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(LocalDate date_closed) {
        this.date_closed = date_closed;
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
}
