package com.example.empapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.empapp.exception.EmployeeException;
import com.example.empapp.model.Employee;
import com.example.empapp.model.ResponseMessage;
import com.example.empapp.service.EmployeeService;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;
	
	@Value("${app.message}")
	private String welcomeMessage;
	
	@GetMapping("/employee")
	public String getDataBaseConnectionDetails() {
		return welcomeMessage;
	}
	

	// Create Employee
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Transactional

	public ResponseEntity<ResponseMessage> create(@Valid @RequestBody Employee employee)
			throws URISyntaxException, EmployeeException {


		// Logic to add employee

		Employee employeeCreated = employeeService.create(employee);
		if (employeeCreated != null) {
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(employeeCreated.getId()).toUri();
			ResponseMessage response = new ResponseMessage("Success", "Employee Created Successfully");
			return ResponseEntity.created(location).body(response);
		} else
			logger.error("Error in creating employee data");
			throw new EmployeeException("Error in creating employee data");
		
	}

	// List Employees
	@GetMapping
	public List<Employee> getAll() throws EmployeeException {

		return employeeService.list();
	}

	// Get Employee
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Employee get(@PathVariable int id) throws EmployeeException {

		try {
			return employeeService.get(id);
		} catch (EmployeeException e) {
			logger.error("Employee not found for id :: " + id);
			throw new EmployeeException(" Employee not found for id :: " + id);
		}
	}


	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> update(@PathVariable("id") int id, @RequestBody Employee employee)
			throws EmployeeException {
		employee.setId(id);
		if (employeeService.update(id, employee) != null) {
			ResponseMessage response = new ResponseMessage("Success", "Employee Updated Successfully");
						
			return ResponseEntity.created(null).body(response);
		} else {
			logger.error("Employee not found for id :: " + id + " Update has not happened");
			return ResponseEntity.notFound().build();

		}
	}

	// Delete Employee
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> delete(@PathVariable int id) throws EmployeeException {

		if (employeeService.get(id) != null) {
			employeeService.delete(id);
			ResponseMessage response = new ResponseMessage("Success", "Employee Deleted Successfully");
			return ResponseEntity.created(null).body(response);
			
		} else {
			logger.error("Employee not found for id :: " + id + " Delete has not happened");
			return ResponseEntity.notFound().build();

		}

	}



}