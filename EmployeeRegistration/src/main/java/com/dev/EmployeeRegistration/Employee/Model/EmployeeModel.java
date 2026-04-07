package com.dev.EmployeeRegistration.Employee.Model;

import com.dev.EmployeeRegistration.Project.Model.ProjectModel;
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
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Integer age;

  @Column(unique = true)
  private String email;

  @Column(name = "position")
  private String position;

  @ManyToOne
  @JoinColumn(name = "project_id")
  private ProjectModel project;
}
