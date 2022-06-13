package com.examples.empapp.dao;

public interface EmployeeDao {

	// Create/Insert Employee into DB
	public boolean createEmployee(Employee emp);

	// Update Emp data
	public boolean updateEmployee(Employee emp);

	//Delete Emp Data
	public boolean deleteEmployee(int empId);

	//Read Emp data for the given ID
	public Employee get(int empId);

	//Read all Employee
	public List<Employee> displayEmployees();

}