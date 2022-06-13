package com.examples.empapp.service;

public interface UserService {

	  int register(User user);

	  User validateUser(Login login);
	}