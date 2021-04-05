package com.example.graphDemo;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="project")
public class Project {

    // Entity variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int project_ID;
    private String project_name;
    private String assigned_emp;
    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;
    private String project_discription;
    private String status;


    Project( String project_name, String assigned_emp, Date start_date, Date end_date, String project_discription, String status){


        this.project_name=project_name;
        this.assigned_emp=assigned_emp;
        this.start_date=start_date;
        this.end_date=end_date;
        this.project_discription=project_discription;
        this.status=status;
    }

    public Project(){

    }

    // Getters and Setters
    public int getProject_ID() {
        return project_ID;
    }

    public void setProject_ID(int project_ID) {
        this.project_ID = project_ID;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getAssigned_emp() {
        return assigned_emp;
    }

    public void setAssigned_emp(String assigned_emp) {
        this.assigned_emp = assigned_emp;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getProject_discription() {
        return project_discription;
    }

    public void setProject_discription(String project_discription) {
        this.project_discription = project_discription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
