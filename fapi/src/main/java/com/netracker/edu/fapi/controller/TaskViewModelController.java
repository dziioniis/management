package com.netracker.edu.fapi.controller;

import com.netracker.edu.fapi.model.TaskResponse;
import com.netracker.edu.fapi.model.TaskViewModel;
import com.netracker.edu.fapi.service.TaskViewModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskViewModelController {
    @Autowired
    TaskViewModelService taskDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TaskViewModel> saveTask(@RequestBody TaskViewModel taskViewModel ) {
        System.out.println(taskViewModel.toString());
        return ResponseEntity.ok(taskDataService.saveTask(taskViewModel));
    }
    @RequestMapping("/update")
    public ResponseEntity<TaskViewModel> updateTask(@RequestBody TaskViewModel taskViewModel ) {
        System.out.println(taskViewModel.toString());
        return ResponseEntity.ok(taskDataService.updateTask(taskViewModel));
    }
    @RequestMapping("/change")
    public ResponseEntity<TaskViewModel> changeTask(@RequestBody TaskViewModel taskViewModel ) {
        System.out.println(taskViewModel.toString());
        return ResponseEntity.ok(taskDataService.changeTask(taskViewModel));
    }
    @RequestMapping("/byAssignee")
    public ResponseEntity<List<TaskViewModel>> getTaskByAssignee(@RequestParam String assignee) {
        System.out.println(assignee);
        return ResponseEntity.ok(taskDataService.getTaskByAssignee(assignee));
    }
    @RequestMapping("/byProject")
    public ResponseEntity<List<TaskViewModel>> getTaskByProject(@RequestParam String projectCode) {
        return ResponseEntity.ok(taskDataService.getTaskByProjectcode(projectCode));
    }

    @RequestMapping
    public ResponseEntity<TaskResponse> getAllTasks(@RequestParam int page) {
        return ResponseEntity.ok(taskDataService.getAllTasks(page));
    }
    @RequestMapping("/search")
    public ResponseEntity<List<TaskViewModel>> searchTask(@RequestParam("ticketCode") String ticketCode ) {
        System.out.println("ticketCode"+ticketCode);
        return ResponseEntity.ok(taskDataService.getByTask(ticketCode));
    }
}
