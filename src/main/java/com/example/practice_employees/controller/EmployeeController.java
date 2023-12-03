package com.example.practice_employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice_employees.service.EmployeeService;
import com.example.practice_employees.model.Employee;
import java.util.List;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping("/email/{email}")
    public List<Employee> findEmployeeByEmail(@PathVariable String email) {
        return employeeService.findByEmail(email);
    }

    @GetMapping("/salary")
    public List<Employee> findEmployeeBySalary() {
        return employeeService.findBySalary();
    }

    @GetMapping("/experience")
    public List<Employee> findEmployeeByExperience() {
        return employeeService.findByExperience();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee e) {
        return employeeService.saveEmployee(e);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee e) {
        return employeeService.updateEmployee(e);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted";
    }
}


