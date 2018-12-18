package com.netcracker.edu.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min=4,max = 25,message="Name should have at least 4 characters")
    private String code;
    @NotNull
    @Size(min = 4,max = 70,message="Name should have at least 4 characters")
    private String summary;
    private String author;
    private String createdDate;
    private String closed;
    private String status;

}
