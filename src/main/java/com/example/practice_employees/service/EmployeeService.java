package com.example.practice_employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice_employees.model.Employee;
import com.example.practice_employees.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }
    
    public List<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> findBySalary() {
        return employeeRepository.findBySalary();
    }

    public List<Employee> findByExperience() {
        return employeeRepository.findByExperience();
    }
    
    public  Employee saveEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    public Employee updateEmployee(Employee e) {
        return employeeRepository.update(e);
    }

    public void deleteEmployee(int id) {
        employeeRepository.delete(id);
    }
}
