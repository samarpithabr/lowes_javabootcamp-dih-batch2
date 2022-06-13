package com.spring.rest.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.spring.rest.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee empObj = new Employee();
		empObj.setEmpId(rs.getInt("id"));
		empObj.setName(rs.getString("name"));
		empObj.setAge(rs.getInt("age"));
		empObj.setDepartment(rs.getString("department"));
		empObj.setDesignation(rs.getString("designation"));
		empObj.setCountry(rs.getString("country"));

		return empObj;
	}

}
