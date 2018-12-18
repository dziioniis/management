package com.netracker.edu.fapi.service.impl;

import com.netracker.edu.fapi.model.CommentViewModel;
import com.netracker.edu.fapi.service.CommentModelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CommentServiceViewModelServiceImpl implements CommentModelService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public CommentViewModel saveCommentViewModel(CommentViewModel commentViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/comment",commentViewModel, CommentViewModel.class).getBody();
    }

    @Override
    public List<CommentViewModel> getComments() {
        RestTemplate restTemplate = new RestTemplate();
        CommentViewModel[] commentViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/comment", CommentViewModel[].class);
        return commentViewModelResponse == null ? Collections.emptyList() : Arrays.asList(commentViewModelResponse);
    }

    @Override
    public List<CommentViewModel> getCommentsByTask(long task) {
        System.out.println("taskofComment"+task);
        RestTemplate restTemplate = new RestTemplate();
        CommentViewModel[] commentViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/comment/task?task="+task, CommentViewModel[].class);
        return commentViewModelResponse == null ? Collections.emptyList() : Arrays.asList(commentViewModelResponse);
    }
}
