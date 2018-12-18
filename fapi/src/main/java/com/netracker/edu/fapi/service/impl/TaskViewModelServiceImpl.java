package com.netracker.edu.fapi.service.impl;

import com.netracker.edu.fapi.model.TaskResponse;
import com.netracker.edu.fapi.model.TaskViewModel;
import com.netracker.edu.fapi.service.TaskViewModelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TaskViewModelServiceImpl implements TaskViewModelService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    @PreAuthorize("hasAuthority('MANAGER')")
    public TaskViewModel saveTask(TaskViewModel taskViewModel) {
        RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForEntity(backendServerUrl + "/api/task", taskViewModel, TaskViewModel.class).getBody();
    }
    @Override
    @PreAuthorize("hasAuthority('MANAGER')")
    public TaskViewModel updateTask(TaskViewModel taskViewModel) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity( backendServerUrl+ "/api/task/update", taskViewModel, TaskViewModel.class).getBody();
    }
    @Override
    public TaskViewModel changeTask(TaskViewModel taskViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity( backendServerUrl+ "/api/task/change", taskViewModel, TaskViewModel.class).getBody();
    }

    @Override
    public TaskResponse getAllTasks(int page) {
        RestTemplate restTemplate = new RestTemplate();
        TaskResponse  taskResponse= restTemplate.getForObject(backendServerUrl + "/api/task?page="+page, TaskResponse.class);
        return taskResponse;
    }

    @Override
    public List<TaskViewModel> getByTask(String ticketCode) {
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] taskViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/task/search?ticketCode="+ticketCode, TaskViewModel[].class);
        return taskViewModelResponse == null ? Collections.emptyList() : Arrays.asList(taskViewModelResponse);
    }

    @Override
    public List<TaskViewModel> getTaskByAssignee(String name) {
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] taskViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/task/byAssignee?assignee="+name, TaskViewModel[].class);
        return taskViewModelResponse == null ? Collections.emptyList() : Arrays.asList(taskViewModelResponse);
    }


    @Override
    public List<TaskViewModel> getTaskByProjectcode(String name) {
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] taskViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/task/byProject?projectCode="+name, TaskViewModel[].class);
        return taskViewModelResponse == null ? Collections.emptyList() : Arrays.asList(taskViewModelResponse);
    }
}
