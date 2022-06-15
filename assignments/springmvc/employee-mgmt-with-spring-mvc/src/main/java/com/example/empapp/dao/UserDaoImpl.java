package com.example.empapp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.empapp.model.Login;
import com.example.empapp.model.User;

public class UserDaoImpl implements UserDao {

	  @Autowired
	  DataSource dataSource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;

	  public int register(User user) {
	    String sql = "insert into users values(?,?,?,?,?,?,?)";

	    return jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getPassword(), user.getFirstname(),
	        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
	  }

	  public User validateUser(Login login) {
	    String sql = "select * from users where username='" + login.getUserName() + "' and password='" + login.getPassword()
	        + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());

	    return users.size() > 0 ? users.get(0) : null;
	  }

	}