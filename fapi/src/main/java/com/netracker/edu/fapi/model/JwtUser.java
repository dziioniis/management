package com.netracker.edu.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class JwtUser {
    private String username;
    private String password;
    private String role;
    private String email;
    private long id;
    private String token;
    private String refreshToken;

}
