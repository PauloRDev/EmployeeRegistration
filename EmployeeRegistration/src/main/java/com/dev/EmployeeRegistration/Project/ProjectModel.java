package com.dev.EmployeeRegistration.Project;

import com.dev.EmployeeRegistration.Employee.EmployeeModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_project")
public class ProjectModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String projectName;
  private String task;
  private String projectLevel;
  private EmployeeModel employee;


  public ProjectModel() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public String getProjectLevel() {
    return projectLevel;
  }

  public void setProjectLevel(String projectLevel) {
    this.projectLevel = projectLevel;
  }
}
