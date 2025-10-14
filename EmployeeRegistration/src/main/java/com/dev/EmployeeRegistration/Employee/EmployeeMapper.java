package com.dev.EmployeeRegistration.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

  public EmployeeModel map(EmployeeDTO employeeDTO) {
    EmployeeModel employeeModel = new EmployeeModel();

    employeeModel.setId(employeeDTO.getId());
    employeeModel.setName(employeeDTO.getName());
    employeeModel.setEmail(employeeDTO.getEmail());
    employeeModel.setAge(employeeDTO.getAge());
    employeeModel.setPosition(employeeDTO.getPosition());

    return employeeModel;
  }

  public EmployeeDTO map(EmployeeModel employeeModel) {
    EmployeeDTO employeeDTO = new EmployeeDTO();

    employeeDTO.setId(employeeModel.getId());
    employeeDTO.setName(employeeModel.getName());
    employeeDTO.setEmail(employeeModel.getEmail());
    employeeDTO.setAge(employeeModel.getAge());
    employeeDTO.setPosition(employeeModel.getPosition());

    return employeeDTO;
  }
}
