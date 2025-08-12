package com.dev.EmployeeRegistration.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {

  @GetMapping("/welcome")
  public String welcome() {
    return "My first route";
  }
}
