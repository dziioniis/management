package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Role;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/registration")
    public String main(){
        return "registration";
    }
    @PostMapping ("/registration")
    public String addUser(@RequestParam String role,User user){
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.valueOf(role)));
        userRepository.save(user);
        return "redirect:/login";
    }

}
