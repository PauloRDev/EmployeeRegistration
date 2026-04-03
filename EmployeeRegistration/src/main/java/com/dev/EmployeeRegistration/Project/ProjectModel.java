package com.dev.EmployeeRegistration.Project;

import com.dev.EmployeeRegistration.Employee.EmployeeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_project")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProjectModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "projectName")
  private String projectName;

  @Column(name = "task")
  private String task;

  @Column(name = "projectLevel")
  private String projectLevel;

  @OneToMany(mappedBy = "project")
  @JsonIgnore
  private List<EmployeeModel> employee;
}
