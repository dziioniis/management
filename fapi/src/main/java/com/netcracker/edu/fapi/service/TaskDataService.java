package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.TaskViewModel;

import java.util.List;

public interface TaskDataService {
    TaskViewModel saveTask(TaskViewModel taskViewModel);
    List<TaskViewModel> getAllTasks();
}


