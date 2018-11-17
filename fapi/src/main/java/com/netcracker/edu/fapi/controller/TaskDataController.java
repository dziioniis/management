package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.TaskViewModel;
import com.netcracker.edu.fapi.service.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskDataController {
    @Autowired
    TaskDataService taskDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TaskViewModel> saveTask(@RequestBody TaskViewModel taskViewModel ) {
        return ResponseEntity.ok(taskDataService.saveTask(taskViewModel));
    }
    @RequestMapping("/update")
    public ResponseEntity<TaskViewModel> updateTask(@RequestBody TaskViewModel taskViewModel ) {
        System.out.println(taskViewModel.toString());
        return ResponseEntity.ok(taskDataService.updateTask(taskViewModel));
    }

    @RequestMapping(params = { "page", "size" })
    public ResponseEntity<List<TaskViewModel>> getAllTasks() {
        return ResponseEntity.ok(taskDataService.getAllTasks());
    }
}
