package com.examples.empapp.service;

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