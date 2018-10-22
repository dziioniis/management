package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Project;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        System.out.println(project.toString());
        return projectService.saveProject(project);
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Project> getProjects() {
        return projectService.getProjects();
    }
}
