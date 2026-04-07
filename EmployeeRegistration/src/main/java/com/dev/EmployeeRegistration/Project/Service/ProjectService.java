package com.dev.EmployeeRegistration.Project.Service;

import com.dev.EmployeeRegistration.Project.DTO.ProjectDTO;
import com.dev.EmployeeRegistration.Project.Mapper.ProjectMapper;
import com.dev.EmployeeRegistration.Project.Model.ProjectModel;
import com.dev.EmployeeRegistration.Project.Repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

  private ProjectRepository projectRepository;
  private ProjectMapper projectMapper;

  public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
    this.projectRepository = projectRepository;
    this.projectMapper = projectMapper;
  }

  public ProjectDTO createProject(ProjectDTO projectDTO) {
    ProjectModel project = projectMapper.map(projectDTO);
    project = projectRepository.save(project);
    return projectMapper.map(project);
  }

  public List<ProjectDTO> listProject() {
    List<ProjectModel> project = projectRepository.findAll();
    return project.stream()
            .map(projectMapper::map)
            .collect(Collectors.toList());
  }

  public ProjectDTO listAllProject(Long id) {
    Optional<ProjectModel> projectByID = projectRepository.findById(id);
    return projectByID.map(projectMapper::map).orElse(null);
  }

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

  public boolean deleteProjectByID(Long id) {
    if (!projectRepository.existsById(id)) return false;
    projectRepository.deleteById(id);
    return true;
  }
}