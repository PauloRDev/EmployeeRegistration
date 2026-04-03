package com.dev.EmployeeRegistration.Project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

  private final ProjectService projectService;

  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  // CREATE
  @PostMapping("/create")
  public ResponseEntity<String> createProject(@RequestBody ProjectDTO project) {
    ProjectDTO newProject = projectService.createProject(project);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Project successfully created " + newProject.getProjectName() + " (ID) " + newProject.getId());
  }

  // GET
  @GetMapping("/list")
  public ResponseEntity<List<ProjectDTO>> listProject() {
    List<ProjectDTO> project = projectService.listProject();
    return ResponseEntity.ok(project);
  }

  @GetMapping("list/{id}")
  public ResponseEntity<?> listAllProjectByID(@PathVariable Long id) {
    ProjectDTO project = projectService.listAllProject(id);

    if (project != null) {
      return ResponseEntity.ok(project);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("this project by ID: " + id + " don't exist");
    }
  }

  // PUT
  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody ProjectDTO updateProject) {
    ProjectDTO project = projectService.updateProjectByID(id, updateProject);

    if (project != null) {
      return ResponseEntity.ok(project);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Project by this ID: " + id + " not exist");
    }
  }

  // DELETE
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteProject(@PathVariable Long id) {
    if (projectService.listAllProject(id) != null) {
      projectService.deleteProjectByID(id);
      return ResponseEntity.ok("Project by ID " + id + " Successfully deleted");
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("The project with ID " + id + " not found");
    }
  }
}