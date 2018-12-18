package com.netracker.edu.fapi.service.impl;

import com.netracker.edu.fapi.model.ProjectResponse;
import com.netracker.edu.fapi.model.ProjectViewModel;
import com.netracker.edu.fapi.service.ProjectViewModelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectViewModelServiceImpl implements ProjectViewModelService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    @PreAuthorize("hasAuthority('MANAGER')")
    public ProjectViewModel saveProjectViewModel(ProjectViewModel projectViewModel) {
        try {
            ProjectViewModel project = loadByCode(projectViewModel.getCode());
        }catch(Exception e){
         return null;
        }
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForEntity(backendServerUrl + "/api/project", projectViewModel, ProjectViewModel.class).getBody();
        }



    @Override
    public List<ProjectViewModel> getProjectViewModels() {
        RestTemplate restTemplate = new RestTemplate();
        ProjectViewModel[] projectViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/project", ProjectViewModel[].class);
        return projectViewModelResponse == null ? Collections.emptyList() : Arrays.asList(projectViewModelResponse);
    }

    @Override
    public ProjectResponse getProjectsOfPage(int page) {
        RestTemplate restTemplate = new RestTemplate();
        ProjectResponse projectViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/project?page="+page, ProjectResponse.class);
        return projectViewModelResponse;
    }

    @Override
    public ProjectViewModel loadByCode(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/project/check", name, ProjectViewModel.class).getBody();
    }

}
