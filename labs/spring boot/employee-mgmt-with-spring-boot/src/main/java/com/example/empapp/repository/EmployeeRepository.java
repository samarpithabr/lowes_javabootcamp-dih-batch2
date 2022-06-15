package com.example.empapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.empapp.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findByType(String type);
	
	public List<Employee> findByTypeAndOwner(String type, String owner);
	
	@Query("Select a FROM Account a WHERE type=:accType")
	public List<Employee> findByAccountType(String accType);
	
	@Query("Select a FROM Account a WHERE type=:accType AND balance > :balance")
	public List<Employee> findByAccountTypeAndBalance(String accType, double balance);

}
