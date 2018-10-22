package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Project;
import com.netcracker.edu.backend.repository.ProjectRepository;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Iterable<Project> getProjects() {
        return projectRepository.findAll();
    }
}
