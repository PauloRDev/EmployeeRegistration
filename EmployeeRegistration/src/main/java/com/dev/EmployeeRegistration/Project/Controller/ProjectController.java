package com.dev.EmployeeRegistration.Project.Controller;

import com.dev.EmployeeRegistration.Project.DTO.ProjectDTO;
import com.dev.EmployeeRegistration.Project.Service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

  private final ProjectService projectService;

  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @PostMapping
  @Operation(summary = "Create a new project", description = "Registers a new project in the system.")

  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Project created successfully"),
          @ApiResponse(responseCode = "400", description = "Error when creating project")
  })

  public ResponseEntity<String> createProject(@RequestBody ProjectDTO project) {
    ProjectDTO newProject = projectService.createProject(project);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Project successfully created " + newProject.getProjectName() + " (ID) " + newProject.getId());
  }

  // GET
  @GetMapping
  @Operation(summary = "Get all projects", description = "Returns a list of all registered projects. Returns an empty list if none exist.")
  @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Projects list returned successfully") })
  public ResponseEntity<List<ProjectDTO>> listProject() {
    List<ProjectDTO> project = projectService.listProject();
    return ResponseEntity.ok(project);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get project by ID", description = "Returns a specific project's data by their unique identifier.")

  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Project successfully found"),
          @ApiResponse(responseCode = "404", description = "Project not found")
  })

  public ResponseEntity<?> listAllProjectByID(
    @Parameter(description = "ID of the project to be returns")
    @PathVariable Long id) {
    ProjectDTO project = projectService.listAllProject(id);

    if (project != null) {
      return ResponseEntity.ok(project);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("this project by ID: " + id + " don't exist");
    }
  }

  // PUT
  @PutMapping("/{id}")
  @Operation(summary = "Update project by ID", description = "Update a specific project's data by their unique identifier.")

  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Project successfully updated"),
          @ApiResponse(responseCode = "404", description = "Project not found, update not possible")
  })

  public ResponseEntity<?> updateProject(
    @Parameter(description = "The user sends the ID in the request path.")
    @PathVariable Long id,
    @Parameter(description = "The user sends the project's data to be updated in the body of the request.")
    @RequestBody ProjectDTO updateProject) {
    ProjectDTO project = projectService.updateProjectByID(id, updateProject);

    if (project != null) {
      return ResponseEntity.ok(project);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Project by this ID: " + id + " not exist");
    }
  }

  // DELETE
  @DeleteMapping("/{id}")
  @Operation(summary = "Delete project by ID", description = "Deletes a specific project by their unique identifier.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "204", description = "Project successfully deleted"),
          @ApiResponse(responseCode = "404", description = "Project not found")
  })

  public ResponseEntity<String> deleteProjectByID(

    @Parameter(description = "ID of the project to be deleted")
    @PathVariable Long id) {
    if (projectService.deleteProjectByID(id)) {
      return ResponseEntity.ok("Project by ID " + id + " Successfully deleted");
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("The project with ID " + id + " not found");
    }
  }
}