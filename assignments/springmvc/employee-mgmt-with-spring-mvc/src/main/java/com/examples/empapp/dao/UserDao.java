package com.examples.empapp.dao;

public interface UserDao {

	  int register(User user);

	  User validateUser(Login login);
	}