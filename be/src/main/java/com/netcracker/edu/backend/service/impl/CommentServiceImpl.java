package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.repository.CommentRepository;
import com.netcracker.edu.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public Comment saveComment(Comment comment) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        comment.setDate(dateFormat.format(date));
        return commentRepository.save(comment);
    }

    @Override
    public Iterable<Comment> getComments() {
       return commentRepository.findAll();
    }

    @Override
    public Iterable<Comment> getCommentsByTask(long id) {
        return commentRepository.findByTaskId(id);
    }
}
