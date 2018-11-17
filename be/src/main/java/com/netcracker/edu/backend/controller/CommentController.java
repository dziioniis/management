package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin(origins="http://localhost:4800",allowedHeaders = "*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public Comment saveComment(@RequestBody Comment comment) {
        System.out.println(comment.toString());
    return commentService.saveComment(comment);
    }
    @GetMapping(value = "/{task}")
    public Iterable<Comment> getComments(@PathVariable long task) {
        System.out.println("task"+task);
        return commentService.getCommentsByTask(task);
    }
}
