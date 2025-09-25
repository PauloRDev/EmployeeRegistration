package com.dev.EmployeeRegistration.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/welcome")
  public String welcome() {
    return "My first route";
  }

  @PostMapping("/create")
  public String createEmployee() {
    return "Employee created";
  }

  @GetMapping("/all")
    public List<EmployeeModel> listEmployee() {
      return employeeService.listEmployee();
    }

  @GetMapping("/employee/{id}")
  public EmployeeModel listEmployeeByID(@PathVariable Long id) {
    return employeeService.listEmployeeByID(id);
  }

  @PutMapping("/updateID")
  public String updateEmployeeByID() {
    return "Change employee data by ID";
  }

  @DeleteMapping("/deleteID")
  public String deleteEmployeeByID() {
    return "Deleted employee by ID";
  }
}
