package com.dev.EmployeeRegistration.Project;

import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
  public ProjectModel map(ProjectDTO projectDTO) {
    ProjectModel projectModel = new ProjectModel();

    projectModel.setId(projectDTO.getId());
    projectModel.setProjectName(projectDTO.getProjectName());
    projectModel.setTask(projectDTO.getTask());
    projectModel.setProjectLevel(projectDTO.getProjectLevel());

    return projectModel;
  }

  public ProjectDTO map(ProjectModel projectModel) {
    ProjectDTO projectDTO = new ProjectDTO();

    projectDTO.setId(projectModel.getId());
    projectDTO.setProjectName(projectModel.getProjectName());
    projectDTO.setTask(projectModel.getTask());
    projectDTO.setProjectLevel(projectModel.getProjectLevel());

    return projectDTO;
  }
}