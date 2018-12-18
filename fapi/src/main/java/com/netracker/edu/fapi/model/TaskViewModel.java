package com.netracker.edu.fapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskViewModel {
    private long id;
    private String projectCode;
    private String ticketCode;
    private String description;
    private String priority;
    private String assignee;
    private String createdDate;
    private String updatedDate;
    private String dueDate;
    private String reporter;
    private String estimation;
    private String status;
    private String resolved;
    private String closed;
}
