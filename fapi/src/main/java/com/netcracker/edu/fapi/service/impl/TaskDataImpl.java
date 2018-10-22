package com.netcracker.edu.fapi.service.impl;


import com.netcracker.edu.fapi.models.TaskViewModel;
import com.netcracker.edu.fapi.service.TaskDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TaskDataImpl implements TaskDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public TaskViewModel saveTask(TaskViewModel taskViewModel) {
        RestTemplate restTemplate =new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl+"/api/task",taskViewModel,TaskViewModel.class).getBody();
    }

    @Override
    public List<TaskViewModel> getAllTasks() {
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] taskViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/task", TaskViewModel[].class);
        return taskViewModelResponse == null ? Collections.emptyList() : Arrays.asList(taskViewModelResponse);
    }
}
