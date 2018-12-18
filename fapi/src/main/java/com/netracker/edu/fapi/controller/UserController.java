package com.netracker.edu.fapi.controller;

import com.netracker.edu.fapi.model.JwtUser;
import com.netracker.edu.fapi.model.UserViewModel;
import com.netracker.edu.fapi.service.UserViewModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserViewModelService userDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserViewModel> saveUser(@RequestBody JwtUser user) {
        if (user != null) {
            return ResponseEntity.ok(userDataService.saveUser(user));
        }
        return null;
    }
    @RequestMapping("/update")
    public ResponseEntity<UserViewModel> updateUser(@RequestBody JwtUser user) {
        if (user != null) {
            return ResponseEntity.ok(userDataService.updateUser(user));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<JwtUser>> getUsers() {
        return ResponseEntity.ok(userDataService.getAll());
    }
}

