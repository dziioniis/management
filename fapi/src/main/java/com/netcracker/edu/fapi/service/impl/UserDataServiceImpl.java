package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class UserDataServiceImpl implements UserDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public List<UserViewModel> getAll() {
        return null;
    }

    @Override
    public UserViewModel getUserById(Long id) {
        return null;
    }

    @Override
    public UserViewModel saveUser(UserViewModel user) {
        ClientHttpRequestFactory requestFactory = new
                    HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        System.out.println("before request");
        System.out.println("SERVER"+restTemplate.postForEntity(backendServerUrl + "/api/user", user, UserViewModel.class).getBody());
        return restTemplate.postForEntity(backendServerUrl + "/api/user",user, UserViewModel.class).getBody();
    }

    /* @Override
    public BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/billing-accounts", account, BillingAccountViewModel.class).getBody();
    }*/

    @Override
    public void deleteUser(Long id) {

    }
}
