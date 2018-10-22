package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Task;

public interface TaskService {
    Task saveTask(Task task);
    Iterable<Task> getAllTasks();
}
