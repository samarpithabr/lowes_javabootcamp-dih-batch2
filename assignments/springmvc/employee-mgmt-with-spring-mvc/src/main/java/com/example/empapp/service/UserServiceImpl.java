package com.example.empapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.empapp.dao.UserDao;
import com.example.empapp.model.Login;
import com.example.empapp.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}