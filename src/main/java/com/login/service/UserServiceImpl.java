package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.dao.UserDAO;
import com.login.model.LoginModel;
import com.login.model.UserModel;
import com.login.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	public String addUser(UserModel usermodel) {
		User user = new User();
		user.setFirstName(usermodel.getFirstName());
		user.setLastName(usermodel.getLastName());
		user.setPassword(usermodel.getPassword());
		user.setRole(usermodel.getRole());
		user.setUserName(usermodel.getUserName());	
		return userDAO.addUser(user);
	}

	@Override
	public boolean getUserByUserNamePassword(LoginModel login) {
		User user = new User();
		user.setUserName(login.getUserName());
		user.setPassword(login.getPassword());
		return userDAO.getUserByUserNamePassword(login);
	}
}