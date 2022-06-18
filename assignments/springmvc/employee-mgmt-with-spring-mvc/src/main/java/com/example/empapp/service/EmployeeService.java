package com.example.empapp.service;

import java.util.List;

import com.example.empapp.exception.EmployeeException;
import com.example.empapp.model.Employee;




public interface EmployeeService {

	public boolean createEmployee(Employee emp);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(int empId);

	public Employee get(int empId) throws EmployeeException;

	public List<Employee> displayEmployees();
	
}