package com.login.dao;

import com.exception.InvalidLoginException;
import com.login.entity.User;
import com.login.model.LoginModel;

public interface UserDAO {
	
	public String addUser(User user);
	public void getUserByUserNamePassword(LoginModel login) throws InvalidLoginException;

}
