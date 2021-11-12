package com.atmecs.springboot.service;

import java.util.List;

import com.atmecs.springboot.model.Employee;

/**
 * 
 * saveEmployee method is declared here and then declared in service class
 *
 */
public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);

}
