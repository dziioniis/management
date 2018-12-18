package com.netracker.edu.fapi.controller;

import com.netracker.edu.fapi.model.ProjectResponse;
import com.netracker.edu.fapi.model.ProjectViewModel;
import com.netracker.edu.fapi.model.TaskViewModel;
import com.netracker.edu.fapi.service.ProjectViewModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectViewModelController {
    @Autowired
    ProjectViewModelService projectDataService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProjectViewModel> saveProject(@RequestBody ProjectViewModel projectViewModel ) {
        return ResponseEntity.ok(projectDataService.saveProjectViewModel(projectViewModel));
    }

    @RequestMapping
    public ResponseEntity<List<ProjectViewModel>> getAllProjects() {
        return ResponseEntity.ok(projectDataService.getProjectViewModels());
    }
    @RequestMapping("/page")
    public ResponseEntity<ProjectResponse> getAllTasks(@RequestParam int page) {
        System.out.println("page"+page);
        return ResponseEntity.ok(projectDataService.getProjectsOfPage(page));
    }

}
