package com.login.service;

import com.login.model.LoginModel;
import com.login.model.UserModel;

public interface UserService {
	public String addUser(UserModel user);
	public boolean getUserByUserNamePassword(LoginModel login);

}
