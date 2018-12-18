package com.netracker.edu.fapi.service;

import com.netracker.edu.fapi.model.TaskResponse;
import com.netracker.edu.fapi.model.TaskViewModel;

import java.util.List;

public interface TaskViewModelService {
    TaskViewModel saveTask(TaskViewModel taskViewModel);

    TaskViewModel updateTask(TaskViewModel taskViewModel);

    TaskResponse getAllTasks(int page);

    List<TaskViewModel> getByTask(String name);
    List<TaskViewModel> getTaskByAssignee(String name);
    List<TaskViewModel> getTaskByProjectcode(String name);

    TaskViewModel changeTask(TaskViewModel taskViewModel);

}
