package com.dev.EmployeeRegistration.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping
  @Operation(summary = "Create a new employee", description = "Registers a new employee in the system. Returns the created employee data with the generated ID.")

  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Employee created successfully"),
          @ApiResponse(responseCode = "400", description = "Error when creating employee")
  })

  public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employee) {
    EmployeeDTO newEmployee = employeeService.createEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Employee successfully created " + newEmployee.getName() + " (ID): " + newEmployee.getId());
  }

  @GetMapping
  @Operation(summary = "Get all employees", description = "Returns a list of all registered employees. Returns an empty list if none exist.")
  @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employees list returned successfully") })

  public ResponseEntity<List<EmployeeDTO>> listEmployees() {
    List<EmployeeDTO> employees = employeeService.listEmployees();
    return ResponseEntity.ok(employees);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get employee by ID", description = "Returns a specific employee's data by their unique identifier.")

  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Employee successfully found"),
          @ApiResponse(responseCode = "404", description = "Employee not found")
  })

  public ResponseEntity<?> listAllEmployeesByID(
    @Parameter(description = "ID of the employee to be returns")
    @PathVariable Long id) {
    EmployeeDTO employee = employeeService.listAllEmployeesByID(id);

    if (employee != null) {
      return ResponseEntity.ok(employee);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Employee by this ID: " + id + " not exist");
    }
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update employee by ID", description = "Update a specific employee's data by their unique identifier.")

  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Employee successfully updated"),
          @ApiResponse(responseCode = "404", description = "Employee not found, update not possible")
  })
  public ResponseEntity<?> updateEmployeesByID(
    @Parameter(description = "The user sends the ID in the request path.")
    @PathVariable Long id,
    @Parameter(description = "The user sends the employee's data to be updated in the body of the request.")
    @RequestBody EmployeeDTO updateEmployee) {
    EmployeeDTO employee = employeeService.updateEmployeeByID(id, updateEmployee);

    if (employee != null) {
      return ResponseEntity.ok(employee);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Employee by this ID: " + id + " not exist");
    }
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete employee by ID", description = "Deletes a specific employee by their unique identifier.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "204", description = "Employee successfully deleted"),
          @ApiResponse(responseCode = "404", description = "Employee not found")
  })

  public ResponseEntity<String> deleteEmployeesByID(
    @Parameter(description = "ID of the employee to be deleted")
    @PathVariable Long id) {
    if (employeeService.listAllEmployeesByID(id) != null) {
      employeeService.deleteEmployeeByID(id);

      return ResponseEntity.ok("Employee by ID " + id + " Successfully deleted");

    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("The employee with ID " + id + " not found");
    }
  }
}