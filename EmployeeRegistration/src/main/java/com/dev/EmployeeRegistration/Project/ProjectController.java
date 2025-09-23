package com.dev.EmployeeRegistration.Project;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

  @PostMapping("/create")
  public String createProject () {
    return "Project created";
  }

  @GetMapping("/all")
  public String showAllProjects () {
    return "all projects";
  }

  @GetMapping("/projectID")
  public String showAllProjectByID() {
    return "Project by ID";
  }

  @PutMapping("/updateID")
  public String updateProjectByID() {
    return "updated project data by ID";
  }

  @DeleteMapping("/deleteID")
  public String deleteProjectByID() {
    return "Delete Project by ID";
  }
}
