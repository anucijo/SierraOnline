package com.login.service;

import com.exception.DuplicateUserNameException;
import com.exception.InvalidLoginException;
import com.login.model.LoginModel;
import com.login.model.UserModel;

public interface UserService {
	public void addUser(UserModel user) throws DuplicateUserNameException;
	public void getUserByUserNamePassword(LoginModel login) throws InvalidLoginException;

}
