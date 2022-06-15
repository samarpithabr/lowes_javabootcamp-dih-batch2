package com.example.empapp.dao;

import com.example.empapp.model.Login;
import com.example.empapp.model.User;

public interface UserDao {
	 int register(User user);

	  User validateUser(Login login);
	}