package com.sierra.dao.login;

import java.io.IOException;
import java.util.List;

import com.exception.DuplicateUserNameException;
import com.exception.InvalidLoginException;
import com.sierra.entity.login.User;
import com.sierra.model.login.LoginModel;
import com.sierra.model.search.SearchResponseModel;

public interface UserDAO {
	
	public void addUser(User user) throws DuplicateUserNameException;
	public List<User> getUserByUserNamePassword(LoginModel login) throws InvalidLoginException;
	public List<SearchResponseModel> getVideos(String searchKeyWord) throws InvalidLoginException, IOException;
}
