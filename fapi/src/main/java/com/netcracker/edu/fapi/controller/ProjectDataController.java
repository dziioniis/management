package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.ProjectViewModel;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectDataController {
    @Autowired
    ProjectDataService projectDataService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProjectViewModel> saveProject(@RequestBody ProjectViewModel projectViewModel ) {
            return ResponseEntity.ok(projectDataService.saveProjectViewModel(projectViewModel));
    }

    @RequestMapping
    public ResponseEntity<List<ProjectViewModel>> getAllProjects() {
        return ResponseEntity.ok(projectDataService.getProjectViewModels());
    }




}
