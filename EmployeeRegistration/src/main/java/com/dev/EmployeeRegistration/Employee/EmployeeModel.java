package com.dev.EmployeeRegistration.Employee;

import com.dev.EmployeeRegistration.Project.ProjectModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "tb_register")
public class EmployeeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Integer age;

  @Column(unique = true)
  private String email;

  private String position;

  @ManyToOne
  @JoinColumn(name = "project_id")
  private ProjectModel project;
}
