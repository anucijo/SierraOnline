package com.login.dao;

import java.util.List;

import com.exception.DuplicateUserNameException;
import com.exception.InvalidLoginException;
import com.login.entity.User;
import com.login.model.LoginModel;
import com.login.model.SearchResponseModel;

public interface UserDAO {
	
	public void addUser(User user) throws DuplicateUserNameException;
	public List<User> getUserByUserNamePassword(LoginModel login) throws InvalidLoginException;
	public List<SearchResponseModel> getVideos(String searchKeyWord) throws InvalidLoginException;
}
