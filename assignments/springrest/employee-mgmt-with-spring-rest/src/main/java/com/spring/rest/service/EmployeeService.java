package com.spring.rest.service;

import java.util.List;

import com.spring.rest.exception.EmployeeException;
import com.spring.rest.model.Employee;

public interface EmployeeService {

	public Employee create(Employee emp);

	public Employee update(int id, Employee emp) throws EmployeeException;

	public boolean delete(int empId);

	public Employee get(int empId) throws EmployeeException;

	public List<Employee> getAll();
}
