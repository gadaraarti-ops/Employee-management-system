package com.yessinfotech.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yessinfotech.entity.Employee;
import com.yessinfotech.exception.EmployeeNotFoundException;
import com.yessinfotech.repository.EmployeeRepository;
import com.yessinfotech.service.EmployeeService;


@Service
public class EmployeeServiceimpl implements EmployeeService


{
    @Autowired
	private EmployeeRepository repository;
	@Override
	public Employee saveEmployee(Employee employee) {

		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		 List<Employee> list=repository.findAll();
		 System.out.println("Total Employees="+list.size());
		return repository.findAll();

	}



	@Override
	public Employee updateEmployee(Employee employee) {
		 System.out.println("Before save:"+employee);
		 Employee emp=repository.save(employee);
		 System.out.println("After save:"+emp);
		return emp;
	}



	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(()->
		new
				EmployeeNotFoundException("Employee not found with id:"+id));
	}

	@Override
	public void deleteEmployee(long id) {

		Employee employee = repository.findById(id)
	            .orElseThrow(() ->
	                    new EmployeeNotFoundException("Employee not found with id : " + id));

	    repository.delete(employee);

	}

	@Override
	public List<Employee> searchEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}
	@Override
	public List<Employee> searchEmployeeByDepartment(String department) {
	    return repository.findByDepartment(department);
	}


	@Override
	public List<Employee> sortByName() {
	    return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	@Override
	public List<Employee> sortBySalary() {
	    return repository.findAll(Sort.by(Sort.Direction.DESC, "salary"));
	}


	@Override
	public Page<Employee> getEmployeesWithPagination(int page, int size) {

	    Pageable pageable = PageRequest.of(page, size);

	    return repository.findAll(pageable);
	}
	@Override
	public Map<String, Long> getDepartmentChart() {

	    return repository.findAll()
	            .stream()
	            .collect(Collectors.groupingBy(
	                    Employee::getDepartment,
	                    Collectors.counting()
	            ));
	}

}
