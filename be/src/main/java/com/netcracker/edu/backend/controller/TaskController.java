package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.service.CommentService;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "http://localhost:4800", allowedHeaders = "*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public void saveTask(@RequestBody Task task) {
        taskService.saveTask(task);
    }

    @RequestMapping("/change")
    public void changeTask(@RequestBody Task task) {
        taskService.changeStatus(task);
    }

    @RequestMapping("/update")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Task> getAllTasks(@RequestParam(defaultValue = "1") int page) {
        System.out.println(page);
        return taskService.getAllTasks(page);
    }

    @GetMapping("/search")
    public Iterable<Task> findByTask(@RequestParam String ticketCode) {
        return taskService.findByTask(ticketCode);
    }

    @GetMapping("/byProject")
    public Iterable<Task> findByProject(@RequestParam String projectCode) {
        return taskService.findByProject(projectCode);
    }
    @GetMapping( "/byAssignee")
    public Iterable<Task> findByAssignee(@RequestParam String assignee) {
        System.out.println(assignee);
        return taskService.findByAssignee(assignee);
    }

}
