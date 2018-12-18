package com.netcracker.edu.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "project_code",referencedColumnName="code", nullable = false,insertable=false, updatable=false)
    private Project project;
    @Column(name = "project_code")
    private String projectCode;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "assignee",referencedColumnName="username", nullable = false,insertable=false, updatable=false)
    private User user;
    @Column(name = "ticket_code")
    private String ticketCode;
    @NotNull
    @Size(min = 4,max = 70,message="Name should have at least 4 characters")
    private String description;
    @NotNull
    private String priority;
    @Column(name ="assignee")
    private String assignee;
    @Column(name = "created_date")
    @DateTimeFormat
    private String createdDate;
    @Column(name = "updated_date")
    @DateTimeFormat
    private String updatedDate;
    @Column(name = "due_date")
    @DateTimeFormat
    private String dueDate;
    @NotNull
    private String reporter;
    @NotNull
    @Size(max = 10)
    private String estimation;
    @Column(name = "status")
    @NotNull
    private String status;
    @DateTimeFormat
    private String resolved;
    @DateTimeFormat
    private String closed;
}
