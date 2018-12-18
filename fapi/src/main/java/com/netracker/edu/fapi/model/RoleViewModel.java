package com.netracker.edu.fapi.model;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class RoleViewModel implements GrantedAuthority {
    private Long id;
    private String role;
    @Override
    public String getAuthority() {
        return role;
    }
}
