package com.yessinfotech.controller;
		

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yessinfotech.dto.LoginRequest;
import com.yessinfotech.dto.LoginResponse;
import com.yessinfotech.entity.Employee;
import com.yessinfotech.entity.User;
import com.yessinfotech.repository.EmployeeRepository;
import com.yessinfotech.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeRepository employeeRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
    	User user=userService.login(request.getUsername(), request.getPassword());
    	if(user!=null) {
    		return new LoginResponse("dummy-jwt-token");
    	}
    	throw new RuntimeException("Invalid Username or Password");
		 

    }
    @PostMapping("/register-user")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/register-employee")
    public Employee registerEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}