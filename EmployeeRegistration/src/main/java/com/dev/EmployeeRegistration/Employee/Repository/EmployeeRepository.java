package com.dev.EmployeeRegistration.Employee.Repository;

import com.dev.EmployeeRegistration.Employee.Model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
}
