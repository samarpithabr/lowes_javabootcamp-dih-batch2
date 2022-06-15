package com.example.empapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}