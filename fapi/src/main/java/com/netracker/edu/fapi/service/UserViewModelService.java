package com.netracker.edu.fapi.service;

import com.netracker.edu.fapi.model.JwtUser;
import com.netracker.edu.fapi.model.JwtUserDetails;
import com.netracker.edu.fapi.model.UserViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserViewModelService extends UserDetailsService {
    List<JwtUser> getAll();
    JwtUserDetails getUserById(Long id);
    UserViewModel saveUser(JwtUser user);
    UserViewModel updateUser(JwtUser user);
    void deleteUser(Long id);
    JwtUser AuthUser(JwtUser jwtUser);
    void setRefreshToken(String refreshToken);
    JwtUser RefreshUserToken(String refreshToken,String username);
}
