package com.kavish.tutorials.controller;

import com.kavish.tutorials.model.Employee;
import com.kavish.tutorials.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/")
    public List<Employee> getEmployees() {
        return new ArrayList<>();
    }

    /*@GetMapping("/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable String employeeId) {
        return new Employee(1, "Random", new Department(002, "Accounts"));
    }*/

    @PostMapping("/add")
    public String addEmployee(Employee employee) throws Exception {
        return service.addEmployee(employee);
    }
}
