package com.spring.rest.dao;

import java.util.List;

import com.spring.rest.exception.EmployeeException;
import com.spring.rest.model.Employee;

public interface EmployeeDao {

	public boolean create(Employee emp) throws EmployeeException;

	public Employee update(int empId ,Employee emp) throws EmployeeException;

	public boolean delete(int empId);

	public Employee get(int empId) throws EmployeeException;

	public List<Employee> getAll();

}
