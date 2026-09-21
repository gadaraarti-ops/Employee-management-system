package com.yessinfotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yessinfotech.entity.Employee;
import com.yessinfotech.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class ProfileController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/profile")
    public Employee getProfile() {
        return service.getEmployeeById(2L);
    }

    @PutMapping("/profile")
    public Employee updateProfile(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

}