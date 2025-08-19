package com.dev.EmployeeRegistration.Project;

import com.dev.EmployeeRegistration.Employee.EmployeeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "tb_project")
public class ProjectModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String projectName;
  private String task;
  private String projectLevel;

  @OneToMany(mappedBy = "project")
  private List<EmployeeModel> employee;
}
