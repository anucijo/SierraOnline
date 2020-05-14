package com.login.dao;

import com.exception.DuplicateUserNameException;
import com.exception.InvalidLoginException;
import com.login.entity.User;
import com.login.model.LoginModel;

public interface UserDAO {
	
	public void addUser(User user) throws DuplicateUserNameException;
	public void getUserByUserNamePassword(LoginModel login) throws InvalidLoginException;

}
