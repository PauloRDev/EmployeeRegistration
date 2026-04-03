# Employee Registration API

A RESTful API for employee and project management, built with **Java** and **Spring Boot**.

---

## 📋 Table of Contents

- [About](#about)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Request & Response Examples](#request--response-examples)

---

## About

Employee Registration is a REST API that allows you to manage employees and projects. Each employee can be assigned to a project, and the API returns the full project details nested inside the employee response.

---

## Technologies

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- PostgreSQL (or H2 for development)
- Maven
- Postman
---

## Project Structure

```
src/
└── main/
    └── java/
        └── com/dev/EmployeeRegistration/
            ├── Employee/
            │   ├── EmployeeController.java
            │   ├── EmployeeService.java
            │   ├── EmployeeRepository.java
            │   ├── EmployeeModel.java
            │   ├── EmployeeDTO.java
            │   └── EmployeeMapper.java
            └── Project/
                ├── ProjectController.java
                ├── ProjectService.java
                ├── ProjectRepository.java
                ├── ProjectModel.java
                ├── ProjectDTO.java
                └── ProjectMapper.java
```

---

## Getting Started

### Pre requisites

- Java 17+
- Maven
- PostgreSQL (or configure H2 in `application.properties`)

### Installation

```bash
# Clone the repository
git clone https://github.com/PauloRDev/EmployeeRegistration.git

# Navigate to the project folder
cd EmployeeRegistration

# Run the application
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## API Endpoints

### 🗂️ Project

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/project/create` | Create a new project |
| GET | `/project/list` | List all projects |
| GET | `/project/list/{id}` | Get project by ID |
| PUT | `/project/update/{id}` | Update project by ID |
| DELETE | `/project/delete/{id}` | Delete project by ID |

### 👤 Employee

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/employee/create` | Create a new employee |
| GET | `/employee/list` | List all employees |
| GET | `/employee/list/{id}` | Get employee by ID |
| PUT | `/employee/update/{id}` | Update employee by ID |
| DELETE | `/employee/delete/{id}` | Delete employee by ID |

---

## Request & Response Examples

### Create a Project

**POST** `/project/create`

```json
{
    "projectName": "Authentication Service",
    "task": "Implement JWT login and refresh token",
    "projectLevel": "hard"
}
```

**Response:**
```
Project successfully created Authentication Service (ID) 1
```

---

### Create an Employee

> ⚠️ Create the project first, then assign it to the employee using the project ID.

**POST** `/employee/create`

```json
{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 28,
    "position": "Backend Developer",
    "project": { "id": 1 }
}
```

**Response:**
```
Employee successfully created John Doe (ID): 1
```

---

### Get All Employees

**GET** `/employee/list`

```json
[
    {
        "id": 1,
        "name": "John Doe",
        "email": "john.doe@example.com",
        "age": 28,
        "position": "Backend Developer",
        "project": {
            "id": 1,
            "projectName": "Authentication Service",
            "task": "Implement JWT login and refresh token",
            "projectLevel": "hard"
        }
    }
]
```

---

### Update an Employee

**PUT** `/employee/update/1`

```json
{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 29,
    "position": "Tech Lead",
    "project": { "id": 1 }
}
```

---

### Delete an Employee

**DELETE** `/employee/delete/1`

```
Employee by ID 1 Successfully deleted
```

---

## Author

Made by [PauloRDev](https://github.com/PauloRDev)
