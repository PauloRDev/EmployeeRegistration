package com.dev.EmployeeRegistration.Employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;

  public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
    this.employeeMapper = employeeMapper;
    this.employeeRepository = employeeRepository;
  }

  // list all employees
  public List<EmployeeDTO> listEmployees() {
    List<EmployeeModel> employees = employeeRepository.findAll();
    return employees.stream()
            .map(employeeMapper::map)
            .collect(Collectors.toList());
  }

  // list all employees by ID
  public EmployeeDTO listAllEmployeesByID(Long id) {
    Optional<EmployeeModel> employeeByID = employeeRepository.findById(id);
    return employeeByID.map(employeeMapper::map).orElse(null);
  }

  // create new employee
  public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
    EmployeeModel employee = employeeMapper.map(employeeDTO);
    employee = employeeRepository.save(employee);
    return employeeMapper.map(employee);
  }

  // Delete employee
  public void deleteEmployeeByID(Long id) {
    employeeRepository.deleteById(id);
  }

  // Update employee
  public EmployeeDTO updateEmployeeByID(Long id, EmployeeDTO employeeDTO) {
    Optional<EmployeeModel> existsEmployee = employeeRepository.findById(id);
    if (existsEmployee.isPresent()) {
      EmployeeModel attEmployee = employeeMapper.map(employeeDTO);
      attEmployee.setId(id);
      EmployeeModel savedEmployee = employeeRepository.save(attEmployee);

      return employeeMapper.map(savedEmployee);
    }
    return null;
  }

}