package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Project;
import com.netcracker.edu.backend.repository.ProjectRepository;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        project.setCreatedDate(dtf.format(now));
        project.setStatus("open");
        return projectRepository.save(project);
    }

    @Override
    public Iterable<Project> getProjects(int page) {
        return projectRepository.findAll(PageRequest.of(page,3));
    }

    @Override
    public Iterable<Project> getProjectsAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project loadByCode(String name) {
        return projectRepository.findByCode(name);
    }
}
