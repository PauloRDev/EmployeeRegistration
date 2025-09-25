package com.dev.EmployeeRegistration.Employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  // list all employee by ID
  public EmployeeModel listEmployeeByID(Long id) {
    Optional<EmployeeModel> employeeByID = employeeRepository.findById(id);

    return employeeByID.orElse(null);
  }

}
