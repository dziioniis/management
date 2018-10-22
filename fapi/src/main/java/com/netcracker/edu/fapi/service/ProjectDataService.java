package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ProjectViewModel;

import java.util.List;

public interface ProjectDataService {
    ProjectViewModel saveProjectViewModel(ProjectViewModel projectViewModel);
    List<ProjectViewModel> getProjectViewModels();
}
