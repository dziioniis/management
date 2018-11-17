package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.ProjectViewModel;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.ProjectDataService;
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
public class ProjectDataImpl implements ProjectDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public ProjectViewModel saveProjectViewModel(ProjectViewModel projectViewModel) {
 /*       ClientHttpRequestFactory requestFactory = new
                HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());*/
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/project",projectViewModel, ProjectViewModel.class).getBody();
    }

    @Override
    public List<ProjectViewModel> getProjectViewModels() {
        RestTemplate restTemplate = new RestTemplate();
        ProjectViewModel[] projectViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/project", ProjectViewModel[].class);
        return projectViewModelResponse == null ? Collections.emptyList() : Arrays.asList(projectViewModelResponse);
    }
}
