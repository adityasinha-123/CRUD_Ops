package com.atmecs.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.springboot.model.Employee;
import com.atmecs.springboot.service.EmployeeService;
/**
 * 
 * @RequestController combines @Controller and @ResponseBody, which eliminates the need to annotate every request handling method of controller class with the @ResponseBody
 * the dependency(EmployeeService) is injected and a constructor is generated for it
 * ResponseEntity represent the entire HTTP response, controls anything that goes into it(status code,header's and body)
 * @PostMapping is used to handle Post Http Requests
 * @RequestBody allows us to retrieve the request's body and automatically convert it to java object
 * ResponseEntity is used to pass the body and status
 * @RequestMapping is used to pass the uri
 * @GetMapping is used for mapping Http Get requests onto specific handler methods
 * @PathVariable is used to handle template variables in the request URI mapping
 * @PutMapping is used for mapping Http Put requests onto specific handler methods
 * @DeleteMapping is called to delete the employee from DB
 *
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee REST API
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);

	}
	
	//build get all employees REST API
	@GetMapping
	public List<Employee>getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	
	//build get employee by id REST API
	// http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}
	
	//build update employee REST API
	// http://localhost:8080/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
		
	}
	
	//build delete REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		//delete employee from DB
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
		
	}
	
	

}
