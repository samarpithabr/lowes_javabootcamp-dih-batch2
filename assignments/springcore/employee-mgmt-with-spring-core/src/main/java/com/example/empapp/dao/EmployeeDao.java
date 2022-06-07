package com.example.empapp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empapp.model.Employee;

public interface EmployeeDao {
	public boolean create(Employee employee);

	public boolean update(Employee employee);

	public boolean delete(int id);

	public Employee get(int empId);

	public List<Employee> getAll();
	
	}

