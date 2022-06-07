package com.exampl.empapp.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.empapp.dao.EmployeeDao;
import com.example.empapp.dao.EmployeeJdbcImpl;
import com.example.empapp.exception.EmployeeException;
import com.example.empapp.model.Employee;
import com.example.empapp.service.EmployeeService;
import com.example.empapp.service.EmployeeServiceImpl;
import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class ConfigSetup {
	@Bean ("getDataSource")
	public MysqlDataSource getDataSource() {
		System.out.println("I am in jdbc");
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/jdbctraining");
		dataSource.setUser("training");
		dataSource.setPassword("training");
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;

	}
	

	@Bean("getEmployeeDao")
	public EmployeeDao getEmployeeDao() {
		EmployeeJdbcImpl empDao = new EmployeeJdbcImpl();
		empDao.setMydata(getDataSource());
		return  empDao;
	}

	
	@Bean("employeeService")
	public EmployeeService employeeService() {
	
		return new EmployeeServiceImpl();
	}

	@Bean("getEmployee")
	public Employee getEmployee() {
		return new Employee();
	}

}


