package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.service.CommentService;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins="http://localhost:4800",allowedHeaders = "*")
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
            taskService.changeStatus(task.getId(), task.getStatus());
    }

    @RequestMapping("/update")
    public void updateTask(@RequestBody Task task){
        System.out.println(task.toString()+"hello");
        taskService.updateTask(task);}


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Task> getAllTasks(@RequestParam(defaultValue="1") int page) {
        return taskService.getAllTasks(page);
    }

    @GetMapping(value = "/{ticketCode}")
    public Iterable<Task> findByTask(@PathVariable String ticketCode){
        System.out.println("Task"+ticketCode);
        return taskService.findByTask(ticketCode);
    }

}
