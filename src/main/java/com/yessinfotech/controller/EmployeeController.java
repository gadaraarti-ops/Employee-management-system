package com.yessinfotech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yessinfotech.entity.Employee;
import com.yessinfotech.repository.EmployeeRepository;
import com.yessinfotech.service.EmployeeService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	    @Autowired
	    private EmployeeService service;

	    @Autowired
	    private EmployeeRepository employeeRepository;
	    // Save Employee
	    @PostMapping("/save")
	    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
	        return service.saveEmployee(employee);
	    }

	    // Get All Employees
	    @GetMapping("/all")
	    public List<Employee> getAllEmployees() {
	        return service.getAllEmployees();
	    }

	    // Get Employee By Id
	    @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable long id) {
	        return service.getEmployeeById(id);
	    }

	    // Update Employee
	    @PutMapping("/update")
	    public Employee updateEmployee(@Valid @RequestBody Employee employee) {

	    	System.out.println(employee.getId());
	    	 Employee updated= service.updateEmployee(employee);

	        return  updated;
	    }

	    // Delete Employee
	    @DeleteMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable long id) {
	        service.deleteEmployee(id);
	        return "Employee Deleted Successfully";
	    }
	    @GetMapping("/test")
	    public String test() {
			return "API Working";

	    }
	    @GetMapping("/count")
	    public long count() {
			return service.getAllEmployees().size();

	    }
	    @GetMapping("/search/{name}")
	    public List<Employee> searchEmployeeByName(@PathVariable String name) {
	        return service.searchEmployeeByName(name);
	    }
	    @GetMapping("/department/{department}")
	    public List<Employee> searchEmployeeByDepartment(@PathVariable String department) {
	        return service.searchEmployeeByDepartment(department);
	    }
	    @GetMapping("/sort/name")
	    public List<Employee> sortByName() {
	        return service.sortByName();
	    }
	    @GetMapping("/sort/salary")
	    public List<Employee> sortBySalary() {
	        return service.sortBySalary();
	    }

	    @GetMapping("/page")
	    public Page<Employee> getEmployeesWithPagination(
	            @RequestParam int page,
	            @RequestParam int size) {

	        return service.getEmployeesWithPagination(page, size);
	    }

	        @GetMapping("/dashboard")
	        public Map<String, Object> getDashboardData() {

	            List<Employee> employees =service.getAllEmployees();

	            Map<String, Object> data = new HashMap<>();

	            data.put("totalEmployees", employees.size());

	            data.put("departments",
	                    employees.stream()
	                             .map(Employee::getDepartment)
	                             .distinct()
	                             .count());

	            data.put("activeEmployees", employees.size()); // Sadhya sagle active samja

	            data.put("growth", "18%"); // Nantar dynamic karu

	            return data;



	    }
	        @GetMapping("/department-chart")
	        public Map <String, Long> getDepartmentChart(){
				return service.getDepartmentChart();

	        }
	        

	}


