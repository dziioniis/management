package com.netcracker.edu.backend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    boolean active;
    @NotNull
    @Email
    String email;
    @NotNull
    String password;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "role_id",referencedColumnName = "id",nullable = false,insertable=false, updatable=false)
    private Role role;
    @NotNull
    String username;
    @Column(name = "role_id")
    private long roleId;
    @Column(name="refresh_token")
    private String refreshToken;
}
