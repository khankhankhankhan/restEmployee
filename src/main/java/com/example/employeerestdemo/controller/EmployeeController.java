package com.example.employeerestdemo.controller;

import com.example.employeerestdemo.model.Employee;
import com.example.employeerestdemo.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/employees")
    public Employee creatEmployee(@Valid @RequestBody Employee input) {
        Employee res = employeeDao.save(input);
        return res;
    }


    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeDao.findById(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(@RequestBody)
}
