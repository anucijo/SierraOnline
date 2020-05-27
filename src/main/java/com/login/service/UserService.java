package com.login.service;

import com.exception.DuplicateUserNameException;
import com.exception.InvalidLoginException;
import com.login.model.LoginModel;
import com.login.model.UserModel;
import com.login.model.UserResponseModel;

public interface UserService {
	public void addUser(UserModel user) throws DuplicateUserNameException;
	public UserResponseModel getUserByUserNamePassword(LoginModel login) throws InvalidLoginException;
}
