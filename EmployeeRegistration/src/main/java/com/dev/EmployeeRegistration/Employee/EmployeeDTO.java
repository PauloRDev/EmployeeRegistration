package com.dev.EmployeeRegistration.Employee;

import com.dev.EmployeeRegistration.Project.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
  private Long id;
  private String name;
  private String email;
  private Integer age;
  private String position;

  private ProjectDTO project;
}