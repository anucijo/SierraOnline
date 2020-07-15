package com.sierra.service.login;

import com.exception.DuplicateUserNameException;
import com.exception.InvalidLoginException;
import com.sierra.model.login.LoginModel;
import com.sierra.model.login.UserModel;
import com.sierra.model.login.UserResponseModel;

public interface UserService {
	public void addUser(UserModel user) throws DuplicateUserNameException;
	public UserResponseModel getUserByUserNamePassword(LoginModel login) throws InvalidLoginException;
}
