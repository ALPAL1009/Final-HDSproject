package com.hds.model;

import javax.persistence.*;
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
    private Date date_open;

    @Column(name = "DateClosed")
    private Date date_closed;


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

    public Date getDate_open() {
        return date_open;
    }

    public void setDate_open(Date date_open) {
        this.date_open = date_open;
    }

    public Date getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(Date date_closed) {
        this.date_closed = date_closed;
    }
}
