package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import exception.EmployeeException;
import model.Employee;

public interface EmployeeService {
	public boolean create(Employee emp);

	public boolean update(Employee emp);

	public boolean delete(int empId);

	public Employee get(int empId) throws SQLException, Exception;

	public List<Employee> getAll();

	public void bulkImport();

	public void bulkExport();
	public boolean validate(Employee emp, Predicate<Employee> Condition);

	public long getEmployeeCountAgeGreaterThan(Predicate<Employee> condition);

	public List<Integer> getEmployeesIdsAgeGreaterThan(int age);

	public Map<String, Long> getEmployeeCountByBeparment();
	
	public Map<String,Long> getEmployeeCountByDepartmentOrder();
	
	public List<String> getDepartmentsHaveEmployeeMorethan(int criteria);
	
	public List<String> getEmployeeNameStartsWith(String s);
	
	
}
