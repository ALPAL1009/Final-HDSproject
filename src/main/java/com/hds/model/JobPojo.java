package com.hds.model;

import javax.persistence.*;

@Entity
@Table(name = "Job")
public class JobPojo {

    @Id
    @Column(name = "JobID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int job_id;

    @Column(name = "JobPositionID")
    private int job_position_id;

    @Column(name = "YearlySalary")
    private double yearly_salary;


    // Getter Setter methods


    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getJob_position_id() {
        return job_position_id;
    }

    public void setJob_position_id(int job_position_id) {
        this.job_position_id = job_position_id;
    }

    public double getYearly_salary() {
        return yearly_salary;
    }

    public void setYearly_salary(double yearly_salary) {
        this.yearly_salary = yearly_salary;
    }
}
