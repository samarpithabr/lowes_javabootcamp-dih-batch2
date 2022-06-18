package com.example.empapp.service;

import com.example.empapp.model.Login;
import com.example.empapp.model.User;

public interface UserService {

	  int register(User user);

	  User validateUser(Login login);
	}