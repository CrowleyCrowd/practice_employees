package com.example.practice_employees.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.practice_employees.model.Employee;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee findById(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return employees.get(i);
            }
        }
        return null;
    }

    public List<Employee> findByEmail(String email) {
        return employees.stream()
                .filter(employee -> employee.getEmail().equals(email))
                .collect(Collectors.toList());
    }

    public List<Employee> findBySalary() {
        return employees.stream()
                .filter(employee -> employee.getSalary() >= 1000)
                .collect(Collectors.toList());
    }

    public List<Employee> findByExperience() {
        return employees.stream()
                .filter(employee -> employee.getExperience() >= 5)
                .collect(Collectors.toList());
    }

    public Employee save(Employee e) {
        Employee employee = new Employee();
        employee.setId(e.getId());
        employee.setName(e.getName());
        employee.setLastname(e.getLastname());
        employee.setAge(e.getAge());
        employee.setSalary(e.getSalary());
        employee.setEmail(e.getEmail());
        employee.setExperience(e.getExperience());
        employee.setPhone(e.getPhone());

        employees.add(employee);

        return employee;
    }

    public Employee update(Employee e) {
        int index = 0;
        int id = 0;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == e.getId()) {
                id = e.getId();
                index = i;
                break;
            }
        }

        Employee eupdate = new Employee();
        eupdate.setId(id);
        eupdate.setName(e.getName());
        eupdate.setLastname(e.getLastname());
        eupdate.setAge(e.getAge());
        eupdate.setSalary(e.getSalary());
        eupdate.setEmail(e.getEmail());
        eupdate.setExperience(e.getExperience());
        eupdate.setPhone(e.getPhone());

        employees.set(index, e);
        return eupdate;
    }

    public String delete(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                return "Employee deleted";
            }
        }
        return "Employee not found";
    }

}
