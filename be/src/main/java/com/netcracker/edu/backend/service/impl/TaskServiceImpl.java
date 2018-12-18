package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Task;
import com.netcracker.edu.backend.repository.ProjectRepository;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Task saveTask(Task task) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedDate(dtf.format(now));
        projectRepository.openStatus(task.getProjectCode(), "open");
        long ticketNumber = taskRepository.count() + 1;
        task.setStatus("Open");
        task.setTicketCode(task.getProjectCode() + "-" + ticketNumber);
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAllTasks(int page) {
        return taskRepository.findAll(PageRequest.of(page, 5));
    }

    @Override
    public Iterable<Task> findByTask(String name) {
        return taskRepository.findByTicketCode(name);
    }

    @Override
    public Iterable<Task> findByAssignee(String assignee) {
        return taskRepository.findByAssignee(assignee);
    }

    @Override
    public Iterable<Task> findByProject(String task) {
        List<String> closed = new ArrayList<>();
        LocalDate date = LocalDate.of(1, 1, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        List<Task> taskList = (List<Task>) taskRepository.findByProjectCode(task);
        if (taskList.size() != 0) {
            for (Task tsk : taskList) {
                if (!tsk.getStatus().equals("closed")) {
                    projectRepository.openStatus(task,"open");
                    return taskRepository.findByProjectCode(task);
                } else {
                    closed.add(tsk.getClosed());
                }
            }
            for (String data : closed) {
                LocalDate localDate = LocalDate.parse(data, dtf);
                if (localDate.isAfter(date)) {
                    date = localDate;
                }
            }
            projectRepository.updateStatusAndClosed(task, "closed", dtf.format(date));
            return taskRepository.findByProjectCode(task);
        } else {
            return taskRepository.findByProjectCode(task);
        }
    }

    @Override
    public void changeStatus(Task task) {
        long id = task.getId();
        String status = task.getStatus();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        if (status.equals("resolved")) {
            taskRepository.resolvedStatus(id, status, dtf.format(now));
            findByProject(task.getProjectCode());
        } else if (status.equals("closed")) {
            taskRepository.closedStatus(id, status, dtf.format(now));
            findByProject(task.getProjectCode());
        } else {
            taskRepository.updateStatus(id, status);
            findByProject(task.getProjectCode());
        }
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.updateTask(task.getId(), task.getAssignee(), task.getPriority(), task.getDescription(), task.getReporter(), task.getEstimation());
    }


}
