package com.dev.EmployeeRegistration.Project.Repository;

import com.dev.EmployeeRegistration.Project.Model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
}
