package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {

	public boolean create(Employee employee);

	public boolean update(Employee employee);

	public boolean delete(int id);

	public Employee get(int empId);

	public List<Employee> getAll();
}
