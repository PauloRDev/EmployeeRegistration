package com.dev.EmployeeRegistration.Employee;

import com.dev.EmployeeRegistration.Project.ProjectModel;
import com.dev.EmployeeRegistration.Project.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

  private EmployeeRepository employeeRepository;
  private ProjectRepository projectRepository;
  private EmployeeMapper employeeMapper;

  public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
    this.employeeMapper = employeeMapper;
    this.employeeRepository = employeeRepository;
    this.projectRepository = projectRepository;
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
  public boolean deleteEmployeeByID(Long id) {
    if (!employeeRepository.existsById(id)) return false;

    employeeRepository.deleteById(id);
    return true;
  }

  // Update employee
  public EmployeeDTO updateEmployeeByID(Long id, EmployeeDTO employeeDTO) {
    Optional<EmployeeModel> existsEmployee = employeeRepository.findById(id);

    if (existsEmployee.isPresent()) {
      EmployeeModel attEmployee = existsEmployee.get();

      attEmployee.setName(employeeDTO.getName());
      attEmployee.setEmail(employeeDTO.getEmail());
      attEmployee.setAge(employeeDTO.getAge());
      attEmployee.setPosition(employeeDTO.getPosition());

      if (employeeDTO.getProject() != null) {
        ProjectModel project = projectRepository.findById(employeeDTO.getProject().getId())
                .orElse(null);
        attEmployee.setProject(project);
      }

      EmployeeModel savedEmployee = employeeRepository.save(attEmployee);
      return employeeMapper.map(savedEmployee);
    }

    return null;
  }


}