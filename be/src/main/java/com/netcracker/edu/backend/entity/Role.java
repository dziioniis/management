package com.netcracker.edu.backend.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DEVELOPER,TESTER,ADMIN,MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }
}
