package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
   private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAllTasks() {
      return  taskRepository.findAll();
    }
}
