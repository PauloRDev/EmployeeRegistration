package com.dev.EmployeeRegistration.Employee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  private EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  // list all employee
  public List<EmployeeModel> listEmployee() {
    return employeeRepository.findAll();
  }
}
