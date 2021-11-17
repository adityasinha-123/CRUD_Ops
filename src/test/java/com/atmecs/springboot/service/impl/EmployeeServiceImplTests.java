package com.atmecs.springboot.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.atmecs.springboot.exception.ResourceNotFoundException;
import com.atmecs.springboot.model.Employee;
import com.atmecs.springboot.repository.EmployeeRepository;

/**
 * 
 * @Mock creates a mock object for a real object employeeRepository.
 * @InjectMocks creates an instance of EmployeeService class and inject all the necessary mocks.
 * @BeforeEach throws Exception before each @Test method.
 * @Test tells JUnit that the final void method to which it is attached can be run as a test case.
 * 'when-thenReturn' returns employees when findAll() method of the mocked object is called.
 * 'assertNotNull' makes sure that the getAllEmployees() should not be null.
 * 'assertEquals' verifies that the expected and actual values are equal.
 *
 */
public class EmployeeServiceImplTests {

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Mock
	EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testGetAllEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("Anil");
		employee.setLastName("Kapoor");
		employee.setDept("Developer");
		employee.setSalary(6000);
		employees.add(employee);
		when(employeeRepository.findAll()).thenReturn(employees);

		List<Employee> e1 = employeeService.getAllEmployees();
		assertNotNull(e1);
		assertEquals(1, e1.get(0).getId());

	}

	@Test
	public void saveEmployeeTest() {
		Employee employee = new Employee();
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.saveEmployee(employee));
	}
	
	

}
