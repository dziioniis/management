package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "project")
    private String projectCode;
    @Column(name = "task")
    private String ticketCode;
    private String description;
    private String priority;
    private String assignee;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "updated_date")
    private String updatedDate;
    @Column(name = "due_date")
    private String dueDate;
    private String reporter;
    private String estimation;
    @Column(name = "status")
    private String status;
    private String resolved;
    private String closed;

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEstimation() {
        return estimation;
    }

    public void setEstimation(String estimation) {
        this.estimation = estimation;
    }

    public Task() {
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", projectCode='" + projectCode + '\'' +
                ", ticketCode='" + ticketCode + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", assignee='" + assignee + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Task(String projectCode, String ticketCode, String description, String priority, String assignee, String createdDate, String updatedDate, String dueDate, String reporter) {
        this.projectCode = projectCode;
        this.ticketCode = ticketCode;
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.dueDate = dueDate;
        this.reporter = reporter;
    }

}
