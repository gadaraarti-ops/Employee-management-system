package com.yessinfotech.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.yessinfotech.entity.Employee;

public interface EmployeeService {
	// Save Employee
    Employee saveEmployee(Employee employee);

    // Get All Employees
    List<Employee> getAllEmployees();

    // Get Employee By Id
    Employee getEmployeeById(long id);

    // Update Employee
    Employee updateEmployee(Employee employee);

    // Delete Employee
    void deleteEmployee(long id);

    List<Employee> searchEmployeeByName(String name);
    List<Employee> searchEmployeeByDepartment(String department);
    List<Employee> sortByName();
    List<Employee> sortBySalary();
    Page<Employee> getEmployeesWithPagination(int page, int size);
    Map<String,Long> getDepartmentChart();


}
