package com.dev.EmployeeRegistration.Project;


import com.dev.EmployeeRegistration.Project.ProjectDTO;
import com.dev.EmployeeRegistration.Project.ProjectMapper;
import com.dev.EmployeeRegistration.Project.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;

  public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
    this.projectRepository = projectRepository;
    this.projectMapper = projectMapper;
  }


  //create project
  public ProjectDTO createProject(ProjectDTO projectDTO) {
    ProjectModel project = projectMapper.map(projectDTO);
    project = projectRepository.save(project);
    return projectMapper.map(project);
  }


  //list all project
  public List<ProjectDTO> listProject() {
    List<ProjectModel> project = projectRepository.findAll();
    return project.stream()
            .map(projectMapper::map)
            .collect(Collectors.toList());
  }

  //list all project by ID
  public ProjectDTO listAllProject(Long id) {
    Optional<ProjectModel> projectByID = projectRepository.findById(id);
    return projectByID.map(projectMapper::map).orElse(null);
  }

  //update project
  public ProjectDTO updateProjectByID(Long id, ProjectDTO projectDTO) {
    Optional<ProjectModel> existsProject = projectRepository.findById(id);

    if (existsProject.isPresent()) {

      ProjectModel attProject = projectMapper.map(projectDTO);
      attProject.setId(id);
      ProjectModel savedProject = projectRepository.save(attProject);

      return projectMapper.map(savedProject);
    }
    return null;
  }

  //delete project
  public void deleteProjectByID(Long id) {
    projectRepository.deleteById(id);
  }
}