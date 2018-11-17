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
        System.out.println("dev"+user.toString()+"role"+user.getRole());
        Collections.singleton(Role.valueOf(user.getRole()));
        user.setActive(true);
        return userservice.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getUsers(){
        return userservice.getUsers();
    }

    @GetMapping(value = "/{name}")
    public User findByTask(@PathVariable String name){
        System.out.println("name"+name);
        return (User) userservice.loadUserByUsername(name);
    }


}
