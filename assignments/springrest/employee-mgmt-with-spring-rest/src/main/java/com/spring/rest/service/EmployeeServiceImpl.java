package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.EmployeeDao;
import com.spring.rest.exception.EmployeeException;
import com.spring.rest.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	List<Employee> empList;

	Employee empObj;
	boolean status;

	@Autowired
	private EmployeeDao empDao;

	public Employee create(Employee emp) {
		try {
		
			empDao.create(emp);

		} catch (Exception e) {
			e.getMessage();
		}
		return emp;
	}

	public Employee update(int id, Employee emp) throws EmployeeException {
		try {
			emp.setEmpId(id);
			empObj = empDao.update(id, emp);
		} catch (EmployeeException e) {
			throw new EmployeeException("Exception in update() method");
		}
		return empObj;
	}

	public boolean delete(int empId) {
		status = empDao.delete(empId);
		return status;
	}

	public Employee get(int empId) throws EmployeeException {
		try {
			empObj = empDao.get(empId);
		} catch (EmployeeException e) {
			throw new EmployeeException("Exception in get() method");
		}
		return empObj;
	}

	public List<Employee> getAll() {
		empList = empDao.getAll();
		return empList;
	}

}
