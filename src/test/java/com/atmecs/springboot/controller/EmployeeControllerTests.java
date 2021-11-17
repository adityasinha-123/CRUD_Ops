package com.atmecs.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.context.WebApplicationContext;

import com.atmecs.springboot.model.Employee;
import com.atmecs.springboot.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
public class EmployeeControllerTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@InjectMocks
	private EmployeeController employeeController;
    
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addEmployeeTest() throws Exception {
		Employee employee = new Employee();
		employee.setId(8L);
		employee.setFirstName("Vijay");
		employee.setLastName("Sinha");
		employee.setDept("Testing");
		employee.setSalary(3000);
		String jsonRequest = om.writeValueAsString(employee);
		MvcResult result = mockMvc.perform(
				post("/api/employees/addEmployee").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assertions.assertTrue(response.isStatus());
	}

}
