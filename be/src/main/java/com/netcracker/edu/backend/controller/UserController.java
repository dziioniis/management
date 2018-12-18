package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Role;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userservice;

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        user.setActive(true);
        return userservice.saveUser(user);
    }

    @RequestMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userservice.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        return userservice.getUsers();
    }

    @RequestMapping("/get")
    public User findByName(@RequestBody String name) {
        return userservice.loadUserByUsername(name);
    }

    @RequestMapping("/refreshToken")
    public void setRefreshToken(@RequestBody String refreshToken) {
        userservice.setRefreshToken(refreshToken);
    }


}
