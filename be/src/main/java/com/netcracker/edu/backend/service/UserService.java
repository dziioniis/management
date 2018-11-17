package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    void deleteUser(Long id);
    public Iterable<User> getUsers();

}
