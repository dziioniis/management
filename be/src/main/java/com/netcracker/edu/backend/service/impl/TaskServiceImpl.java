package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedDate(dtf.format(now));
        long ticketNumber = taskRepository.count() + 1;
        task.setStatus("Open");
        task.setTicketCode(task.getProjectCode() + "-" + ticketNumber);
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAllTasks(int page) {
        return taskRepository.findAll(PageRequest.of(page,5));
    }

    @Override
    public Iterable<Task> findByTask(String name) {
       return taskRepository.findByTicketCode(name);
    }

    @Override
    public void changeStatus(long id, String status) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        if(status.equals("resolved")) {
            taskRepository.resolvedStatus(id, status,dtf.format(now));
        }
        else if (status.equals("closed")){
             taskRepository.closedStatus(id,status,dtf.format(now));
        }
        else {
            taskRepository.updateStatus(id,status);
        }
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.updateTask(task.getId(),task.getAssignee(),task.getPriority(),task.getDescription(),task.getReporter(),task.getEstimation());
    }


}
