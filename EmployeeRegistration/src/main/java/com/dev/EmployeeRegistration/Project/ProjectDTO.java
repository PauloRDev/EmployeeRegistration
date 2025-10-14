package com.dev.EmployeeRegistration.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
  private Long id;

  private String projectName;
  private String task;
  private String projectLevel;
}