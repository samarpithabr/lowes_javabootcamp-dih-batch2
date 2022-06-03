package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import dao.EmployeeDaoJdbcImpl;
import exception.EmployeeException;
import model.Employee;

public class EmployeeServiceArrImpl {

	HashMap<Integer, Employee> employee = new HashMap<Integer, Employee>();

	Employee empObj;
	EmployeeDaoJdbcImpl empDao = new EmployeeDaoJdbcImpl();

	public boolean create(Employee emp) {
		empDao.create(emp);
		return true;
	}

	public boolean update(Employee emp) {
		empDao.update(emp);
		return true;
	}

	public boolean delete(int empId) {
		empDao.delete(empId);
		return false;
	}

	public Employee get(int empId) throws Exception  {
		empDao.get(empId);
		return empObj;
	}

	public List<Employee> getAll() {
		empDao.getAll();
		return (List<Employee>) employee;
	}

	public void bulkImport() {
		empDao.bulkImport();

	}

	public void bulkExport() {
		empDao.bulkExport();

	}

	public void viewData(int empId) throws Exception {
		
		empDao.viewData(empId);
	}

	public void viewAll() {
	
		empDao.viewAll();
	}

	public void printStatistics() {
		// TODO Auto-generated method stub
		empDao.printStatistics();
	}
}