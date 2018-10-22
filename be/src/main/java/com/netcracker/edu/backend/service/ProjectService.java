package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Project;

public interface ProjectService {
    Project saveProject(Project project);
    Iterable<Project>getProjects();
}
