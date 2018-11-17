package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.entity.Task;

public interface CommentService {
    Comment saveComment(Comment comment);
    Iterable<Comment> getComments();
    Iterable<Comment> getCommentsByTask(long id);
}
