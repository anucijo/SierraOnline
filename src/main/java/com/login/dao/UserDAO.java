package com.login.dao;

import com.login.entity.User;
import com.login.model.LoginModel;

public interface UserDAO {
	
	public String addUser(User user);
	public boolean getUserByUserNamePassword(LoginModel login);

}
