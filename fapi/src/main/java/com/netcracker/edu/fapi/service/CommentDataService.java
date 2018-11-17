package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CommentViewModel;

import java.util.List;

public interface CommentDataService {
    CommentViewModel saveCommentViewModel(CommentViewModel commentViewModel);
    List<CommentViewModel> getComments();
    List<CommentViewModel> getCommentsByTask(String taskId);
}
