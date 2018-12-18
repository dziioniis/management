package com.netracker.edu.fapi.controller;

import com.netracker.edu.fapi.model.JwtUser;
import com.netracker.edu.fapi.model.JwtUserDetails;
import com.netracker.edu.fapi.model.RefreshTokenViewModel;
import com.netracker.edu.fapi.model.UserViewModel;
import com.netracker.edu.fapi.service.UserViewModelService;
import com.netracker.edu.fapi.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    UserViewModelService userViewModelService;


    @RequestMapping(method = RequestMethod.POST)
    public JwtUser generate(@RequestBody final JwtUser jwtUser) {
        return userViewModelService.AuthUser(jwtUser);

    }
    @RequestMapping("/refresh")
    public JwtUser refreshAndGetAuthenticationToken(@RequestBody RefreshTokenViewModel refreshTokenViewModel) {
       return userViewModelService.RefreshUserToken(refreshTokenViewModel.getRefresh(),refreshTokenViewModel.getUsername());
    }
}
