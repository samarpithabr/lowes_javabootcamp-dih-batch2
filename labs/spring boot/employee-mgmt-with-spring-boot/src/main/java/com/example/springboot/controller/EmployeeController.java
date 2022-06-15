package com.example.springboot.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	EmployeeService empService;

	// Create Account
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseMessage> create(@RequestBody @Valid Employee account, BindingResult errors) throws URISyntaxException, EmployeeException {
		
		if(errors.hasErrors()) {
			for(ObjectError error:errors.getAllErrors()) {
				logger.error("Validation Error: {} - {} ", error.getObjectName(), error.getDefaultMessage());
			}
			throw new EmployeeException("Validation Errors");
		}
		
		// Logic to add account
		Employee accountCreated = empService.create(account);		
		
		// Build newly created Account resource URI
		// http://localhost:8080/spring-rest-labs/accounts/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(accountCreated.getEmpId()).toUri();
		ResponseMessage response = new ResponseMessage("Success", "Account Created Successfully");
		return ResponseEntity.created(location).body(response);
	}

	// List Accounts
	@GetMapping
	public List<Employee> getAll() throws EmployeeException {
		return empService.list();
	}

	// Get Account
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Employee get(@PathVariable int id) {
		return empService.get(id);
	}

	// Update Account
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody Employee account) {
		account.setEmpId(id);
		Employee updatedAcc = empService.update(id, account);
		return ResponseEntity.ok().body("Account updated successfully");
	}
	
	// Search Accounts
	@GetMapping("/search")
	public List<Employee> search(@RequestParam String type) throws EmployeeException {
		return empService.search(type);
	}	

	// Delete Account
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		empService.delete(id);
		return ResponseEntity.ok().body("Account deleted successfully");
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ResponseMessage>  handleErrors(EmployeeException ex) {
		ResponseMessage response = new ResponseMessage("Failure", ex.getMessage());
		return ResponseEntity.internalServerError().body(response);
	}	

}
