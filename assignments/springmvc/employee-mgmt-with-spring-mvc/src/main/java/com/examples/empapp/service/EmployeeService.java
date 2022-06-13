package com.examples.empapp.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.examples.empapp.model.Employee;


public interface EmployeeService {

	public boolean createEmployee(Employee emp);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(int empId);

	public Employee get(int empId) throws EmployeeException;

	public List<Employee> displayEmployees();
	
}