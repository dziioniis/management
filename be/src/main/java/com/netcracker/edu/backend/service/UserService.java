package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

public interface UserService {
    User saveUser(User user);
    void deleteUser(Long id);
    public Iterable<User> getUsers();
    void setRefreshToken(String refreshToken);
    User loadUserByUsername(String name);
    User updateUser(User user);

}
