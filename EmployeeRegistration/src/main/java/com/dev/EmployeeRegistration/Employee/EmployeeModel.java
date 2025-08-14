package com.dev.EmployeeRegistration.Employee;

import com.dev.EmployeeRegistration.Project.ProjectModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_register")
public class EmployeeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Integer age;
  private String email;
  private String position;
  private List<ProjectModel> project;

  public EmployeeModel() {
  }

  public EmployeeModel(String name, Integer age, String email, String position) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }
}
