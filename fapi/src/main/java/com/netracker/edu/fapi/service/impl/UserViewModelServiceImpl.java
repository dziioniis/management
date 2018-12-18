package com.netracker.edu.fapi.service.impl;

import com.netracker.edu.fapi.model.JwtUser;
import com.netracker.edu.fapi.model.JwtUserDetails;
import com.netracker.edu.fapi.model.UserViewModel;
import com.netracker.edu.fapi.security.JwtGenerator;
import com.netracker.edu.fapi.service.UserViewModelService;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserViewModelServiceImpl implements UserViewModelService {
    @Autowired
    JwtGenerator jwtGenerator;
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<JwtUser> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        List<JwtUser> users = new ArrayList<>();
        UserViewModel[] userViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/user", UserViewModel[].class);
        System.out.println(userViewModelResponse.length);
        for (int a = 0; userViewModelResponse.length > a; a++) {
            JwtUser user = new JwtUser();
            user.setUsername(userViewModelResponse[a].getUsername());
            users.add(user);
        }
        return users;
    }

    @Override
    public JwtUserDetails getUserById(Long id) {
        return null;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserViewModel saveUser(JwtUser user) {
        UserViewModel checkUser=loadUserByUsername(user.getUsername());
        if(checkUser!=null){
            return null;
        }else {
            ClientHttpRequestFactory requestFactory = new
                    HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
            RestTemplate restTemplate = new RestTemplate(requestFactory);
            UserViewModel userViewModel = new UserViewModel();
            userViewModel.setUsername(user.getUsername());
            userViewModel.setEmail(user.getEmail());
            userViewModel.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println("userGetRole" + user.getRole());
            switch (user.getRole()) {
                case "ADMIN":
                    userViewModel.setRoleId(1);
                    break;
                case "DEVELOPER":
                    userViewModel.setRoleId(2);
                    break;
                case "TESTER":
                    userViewModel.setRoleId(3);
                    break;
                case "MANAGER":
                    userViewModel.setRoleId(4);
                    break;
            }
            return restTemplate.postForEntity(backendServerUrl + "/api/user", userViewModel, UserViewModel.class).getBody();
        }
    }

    @Override
    public UserViewModel updateUser(JwtUser user) {
        ClientHttpRequestFactory requestFactory = new
                HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setEmail(user.getEmail());
        if(userViewModel.getPassword()!=null) {
            userViewModel.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userViewModel.setId(user.getId());
        return restTemplate.postForEntity(backendServerUrl + "/api/user/update", userViewModel, UserViewModel.class).getBody();
    }


    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public JwtUser AuthUser(JwtUser jwtUser) {
        UserViewModel userViewModel = (UserViewModel) loadUserByUsername(jwtUser.getUsername());
        if (passwordEncoder.matches(jwtUser.getPassword(), userViewModel.getPassword())) {
            jwtUser.setId(userViewModel.getId());
            jwtUser.setRole(userViewModel.getRole().getRole());
            String token = jwtGenerator.generate(jwtUser);
            String refreshToken = jwtGenerator.refreshToken(jwtUser, token);
            jwtUser.setRefreshToken(refreshToken);
            jwtUser.setToken(token);
            jwtUser.setEmail(userViewModel.getEmail());
            setRefreshToken(refreshToken);
            System.out.println(jwtUser.toString());
            return jwtUser;
        } else {
            return null;
        }
    }

    @Override
    public UserViewModel loadUserByUsername(String name) throws UsernameNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user/get", name, UserViewModel.class).getBody();
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        ClientHttpRequestFactory requestFactory = new
                HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.postForEntity(backendServerUrl + "/api/user/refreshToken", refreshToken, String.class);
    }

    @Override
    public JwtUser RefreshUserToken(String refreshToken, String username) {
        UserViewModel userViewModel = (UserViewModel) loadUserByUsername(username);
        System.out.println("2"+userViewModel.getRefreshToken());
        System.out.println("1"+refreshToken);
        JwtUser jwtUser = new JwtUser();
        if (refreshToken.equals(userViewModel.getRefreshToken())) {
            jwtUser.setId(userViewModel.getId());
            jwtUser.setUsername(userViewModel.getUsername());
            jwtUser.setRole(userViewModel.getRole().getRole());
            String token = jwtGenerator.generate(jwtUser);
            jwtUser.setRefreshToken(jwtGenerator.refreshToken(jwtUser, token));
            jwtUser.setToken(token);
            setRefreshToken(jwtGenerator.refreshToken(jwtUser, token));
            System.out.println("hello REFRESH");
            System.out.println(jwtUser.toString());
            return jwtUser;
        } else {
            return null;
        }
    }
}


