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
    return commentService.saveComment(comment);
    }
    @GetMapping("/task")
    public Iterable<Comment> getComments(@RequestParam long task) {
        System.out.println("comment by task"+task);
        return commentService.getCommentsByTask(task);
    }
}
