package com.example.empapp.service;

import java.util.List;

import com.example.empapp.exception.EmployeeException;
import com.example.empapp.model.Employee;



public interface EmployeeService {
	public Employee create(Employee account) throws EmployeeException;
	public List<Employee> list() throws EmployeeException;
	public Employee get(int id);
	public Employee update(int id, Employee account);
	public void delete(int id);
	public List<Employee> search(String type);

}
