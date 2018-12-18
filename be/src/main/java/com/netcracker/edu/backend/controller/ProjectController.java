package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Project;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Project> getProjects(@RequestParam(defaultValue = "1") int page) {
        return projectService.getProjects(page);
    }

    @GetMapping("/all")
    public Iterable<Project> getProjects() {
        return projectService.getProjectsAll();
    }

    @RequestMapping("/check")
    public Project findByName(@RequestBody String name) {
        return projectService.loadByCode(name);
    }

}
