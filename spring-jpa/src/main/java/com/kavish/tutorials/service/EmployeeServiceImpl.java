package com.kavish.tutorials.service;

import com.kavish.tutorials.model.Employee;
import com.kavish.tutorials.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    EmployeeRepository repository;
    @Override
    public List<Employee> getEmployees() throws Exception {
        return new ArrayList<>();
    }

    @Override
    public String addEmployee(Employee employee) throws Exception {
        repository.save(employee);
        log.info("Employee added with Employee Id : " + employee.getEmployeeId() + " At :" + employee.getTimeStamp());
        return "201 Created";
    }
}
