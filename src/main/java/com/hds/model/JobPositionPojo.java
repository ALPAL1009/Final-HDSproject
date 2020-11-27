package com.hds.model;

import javax.persistence.*;

@Entity
@Table(name = "JobPosition")
public class JobPositionPojo {


    @Id
    @Column(name = "JobPositionID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int job_position_id;

    @Column(name = "JobTitle")
    private String job_title;

    @Column(name = "JobDescription")
    private String job_description;


    // Getter Setter methods


    public int getJob_position_id() {
        return job_position_id;
    }

    public void setJob_position_id(int job_position_id) {
        this.job_position_id = job_position_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }
}
