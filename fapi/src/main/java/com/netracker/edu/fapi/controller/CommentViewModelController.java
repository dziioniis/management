package com.netracker.edu.fapi.controller;

import com.netracker.edu.fapi.model.CommentViewModel;
import com.netracker.edu.fapi.service.CommentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentViewModelController {
    @Autowired
    CommentModelService commentDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CommentViewModel> saveCommentDataViewModel(@RequestBody CommentViewModel commentViewModel){
        System.out.println(commentViewModel.toString());
        return ResponseEntity.ok(commentDataService.saveCommentViewModel(commentViewModel));
    }

    @RequestMapping
    public ResponseEntity<List<CommentViewModel>> getAllTasks() {
        return ResponseEntity.ok(commentDataService.getComments());
    }
    @RequestMapping("/task")
    public ResponseEntity<List<CommentViewModel>> getCommentsByTask(@RequestParam long taskId) {
        System.out.println(taskId);
        return ResponseEntity.ok(commentDataService.getCommentsByTask(taskId));
    }
}


