package com.netracker.edu.fapi.service;

import com.netracker.edu.fapi.model.CommentViewModel;

import java.util.List;

public interface CommentModelService {
    CommentViewModel saveCommentViewModel(CommentViewModel commentViewModel);
    List<CommentViewModel> getComments();
    List<CommentViewModel> getCommentsByTask(long taskId);
}
