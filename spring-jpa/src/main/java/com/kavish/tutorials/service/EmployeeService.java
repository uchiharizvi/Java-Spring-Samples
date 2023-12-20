package com.kavish.tutorials.service;


import com.kavish.tutorials.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees() throws Exception;
    String addEmployee(Employee employee) throws Exception;
}
