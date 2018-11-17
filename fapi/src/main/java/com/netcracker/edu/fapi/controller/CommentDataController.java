package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CommentViewModel;
import com.netcracker.edu.fapi.service.CommentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentDataController {
    @Autowired
    CommentDataService commentDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CommentViewModel> saveCommentDataViewModel(@RequestBody CommentViewModel commentViewModel){
        System.out.println(commentViewModel.toString());
     return ResponseEntity.ok(commentDataService.saveCommentViewModel(commentViewModel));
    }

    @RequestMapping
    public ResponseEntity<List<CommentViewModel>> getAllTasks() {
        return ResponseEntity.ok(commentDataService.getComments());
    }
    @GetMapping(value = "/{task}")
    public ResponseEntity<List<CommentViewModel>> getCommentsByTask(@PathVariable String task) {
        System.out.println(task);
        return ResponseEntity.ok(commentDataService.getCommentsByTask(task));
    }
}

