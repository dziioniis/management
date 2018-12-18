package com.netracker.edu.fapi.service;

import com.netracker.edu.fapi.model.ProjectResponse;
import com.netracker.edu.fapi.model.ProjectViewModel;

import java.util.List;

public interface ProjectViewModelService {
    ProjectViewModel saveProjectViewModel(ProjectViewModel projectViewModel);
    List<ProjectViewModel> getProjectViewModels();
    ProjectResponse getProjectsOfPage(int page);
    ProjectViewModel loadByCode(String name);
}
