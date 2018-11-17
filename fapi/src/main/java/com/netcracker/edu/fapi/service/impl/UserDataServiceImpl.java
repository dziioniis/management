package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class UserDataServiceImpl implements UserDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public List<UserViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/user", UserViewModel[].class);
        return userViewModelResponse == null ? Collections.emptyList() : Arrays.asList(userViewModelResponse);
    }

    @Override
    public UserViewModel getUserById(Long id) {
        return null;
    }

    @Override
    public UserViewModel saveUser(UserViewModel user) {
        System.out.println("UUUUUUUUUUUSER2222"+user.toString());
        ClientHttpRequestFactory requestFactory = new
                    HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
               return restTemplate.postForEntity(backendServerUrl + "/api/user",user, UserViewModel.class).getBody();
    }


    @Override
    public void deleteUser(Long id) {
    }
}
