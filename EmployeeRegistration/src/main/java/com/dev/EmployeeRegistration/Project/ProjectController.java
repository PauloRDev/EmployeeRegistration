package com.dev.EmployeeRegistration.Project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProjectController {

  @GetMapping("/projects")
  public String projects() {
    return "My list of projects";
  }
}
