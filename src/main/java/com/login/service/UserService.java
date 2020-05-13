package com.login.service;

import com.exception.InvalidLoginException;
import com.login.model.LoginModel;
import com.login.model.UserModel;

public interface UserService {
	public String addUser(UserModel user);
	public void getUserByUserNamePassword(LoginModel login) throws InvalidLoginException;

}
