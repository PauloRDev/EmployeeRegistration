package com.dev.EmployeeRegistration.Employee.Mapper;

import com.dev.EmployeeRegistration.Employee.DTO.EmployeeDTO;
import com.dev.EmployeeRegistration.Employee.Model.EmployeeModel;
import com.dev.EmployeeRegistration.Project.DTO.ProjectDTO;
import com.dev.EmployeeRegistration.Project.Model.ProjectModel;
import com.dev.EmployeeRegistration.Project.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

  @Autowired
  private ProjectRepository projectRepository;

  public EmployeeModel map(EmployeeDTO employeeDTO) {
    EmployeeModel employeeModel = new EmployeeModel();

    employeeModel.setId(employeeDTO.getId());
    employeeModel.setName(employeeDTO.getName());
    employeeModel.setEmail(employeeDTO.getEmail());
    employeeModel.setAge(employeeDTO.getAge());
    employeeModel.setPosition(employeeDTO.getPosition());


    if (employeeDTO.getProject() != null && employeeDTO.getProject().getId() != null) {
      ProjectModel project = projectRepository.findById(employeeDTO.getProject().getId())
              .orElse(null);
      employeeModel.setProject(project);
    }

    return employeeModel;
  }

  public EmployeeDTO map(EmployeeModel employeeModel) {
    EmployeeDTO employeeDTO = new EmployeeDTO();

    employeeDTO.setId(employeeModel.getId());
    employeeDTO.setName(employeeModel.getName());
    employeeDTO.setEmail(employeeModel.getEmail());
    employeeDTO.setAge(employeeModel.getAge());
    employeeDTO.setPosition(employeeModel.getPosition());

    if (employeeModel.getProject() != null) {
      ProjectDTO projectDTO = new ProjectDTO();
      projectDTO.setId(employeeModel.getProject().getId());
      projectDTO.setProjectName(employeeModel.getProject().getProjectName());
      projectDTO.setTask(employeeModel.getProject().getTask());
      projectDTO.setProjectLevel(employeeModel.getProject().getProjectLevel());
      employeeDTO.setProject(projectDTO);
    }
    return employeeDTO;
  }
}
