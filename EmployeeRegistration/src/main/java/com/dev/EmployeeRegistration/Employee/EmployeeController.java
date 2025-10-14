package com.dev.EmployeeRegistration.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping("/create")
  public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employee) {
    EmployeeDTO newEmployee = employeeService.createEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Employee successfully created " + newEmployee.getName() + " (ID): " + newEmployee.getId());
  }


  @GetMapping("/list")
  public ResponseEntity<List<EmployeeDTO>> listEmployees() {
    List<EmployeeDTO> employees = employeeService.listEmployees();
    return ResponseEntity.ok(employees);
  }


  @GetMapping("/list/{id}")
  public ResponseEntity<?> listAllEmployeesByID(@PathVariable Long id) {
    EmployeeDTO employee = employeeService.listAllEmployeesByID(id);

    if (employee != null) {
      return ResponseEntity.ok(employee);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Employee by this ID: " + id + " not exist");
    }
  }


  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateEmployeesByID(@PathVariable Long id, @RequestBody EmployeeDTO updateEmployee) {
    EmployeeDTO employee = employeeService.updateEmployeeByID(id, updateEmployee);

    if (employee != null) {
      return ResponseEntity.ok(employee);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Employee by this ID: " + id + " not exist");
    }
  }


  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteEmployeesByID(@PathVariable Long id) {
    if (employeeService.listAllEmployeesByID(id) != null) {
      employeeService.deleteEmployeeByID(id);

      return ResponseEntity.ok("Employee by ID " + id + " Successfully deleted");

    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("The employee with ID " + id + " not found");
    }
  }
}