package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
   private TaskService taskService;

    @RequestMapping(method = RequestMethod.POST)
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
