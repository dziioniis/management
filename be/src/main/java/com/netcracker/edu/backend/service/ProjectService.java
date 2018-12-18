package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Project;
import com.netcracker.edu.backend.entity.User;

public interface ProjectService {
    Project saveProject(Project project);
    Iterable<Project>getProjects(int page);
    Iterable<Project>getProjectsAll();
    Project loadByCode(String name);
}
