package com.sample.test.demo.model;

import javax.persistence.*;

@Entity
@Table
public class TaskDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private int createdDate;
    @Column
    private String assignee;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    public TaskDetails() {
    }

    public TaskDetails(long id, String name, int createdDate, String assignee, Status status) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.assignee = assignee;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", assignee='" + assignee + '\'' +
                ", status=" + status +
                '}';
    }
}
