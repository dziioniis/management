package com.netcracker.edu.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "attachement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String url;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "task_id", nullable = false,insertable=false, updatable=false)
    private Task task;
    @Column(name = "task_id")
    private long taskId;
}