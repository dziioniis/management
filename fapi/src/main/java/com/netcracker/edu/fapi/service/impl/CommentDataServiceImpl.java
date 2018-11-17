package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CommentViewModel;
import com.netcracker.edu.fapi.service.CommentDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CommentDataServiceImpl implements CommentDataService {
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
    public List<CommentViewModel> getCommentsByTask(String task) {
        RestTemplate restTemplate = new RestTemplate();
        CommentViewModel[] commentViewModelResponse = restTemplate.postForEntity(backendServerUrl + "/api/comment/{task}", task, CommentViewModel[].class).getBody();
        return commentViewModelResponse == null ? Collections.emptyList() : Arrays.asList(commentViewModelResponse);
    }
}
