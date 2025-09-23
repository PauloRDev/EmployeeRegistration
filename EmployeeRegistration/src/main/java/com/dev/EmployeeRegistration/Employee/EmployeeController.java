package com.dev.EmployeeRegistration.Employee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @GetMapping("/welcome")
  public String welcome() {
    return "My first route";
  }

  @PostMapping("/create")
  public String createEmployee() {
    return "Employee created";
  }

  @GetMapping("/all")
    public String showAllEmployee() {
      return "all Employee";
    }

  @GetMapping("/employeeID")
  public String showEmployeeByID() {
    return "Employee by ID";
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
