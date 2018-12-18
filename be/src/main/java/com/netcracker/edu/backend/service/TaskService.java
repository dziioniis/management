package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Task;

public interface TaskService {
    Task saveTask(Task task);
    Iterable<Task> getAllTasks(int page);
    Iterable<Task>findByTask(String task);
    Iterable<Task>findByAssignee(String assignee);
    Iterable<Task>findByProject(String project);
    void changeStatus(Task task);
    void updateTask(Task task);
}
