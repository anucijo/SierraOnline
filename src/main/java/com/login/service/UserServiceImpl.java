package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.exception.DuplicateUserNameException;
import com.exception.InvalidLoginException;
import com.login.dao.UserDAO;
import com.login.model.LoginModel;
import com.login.model.UserModel;
import com.login.model.UserResponseModel;
import com.login.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(UserModel usermodel) throws DuplicateUserNameException  {
		try {
			User user = new User();
			user.setFirstName(usermodel.getFirstName());
			user.setLastName(usermodel.getLastName());
			user.setPassword(usermodel.getPassword());
			user.setRole(usermodel.getRole());
			user.setUserName(usermodel.getUserName());	
			userDAO.addUser(user);
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateUserNameException("Duplicate UserName");
		}catch(Exception e) {
			throw new DuplicateUserNameException("Duplicate UserName");
			//e.printStackTrace();
		}
	}

	@Override
	public UserResponseModel getUserByUserNamePassword(LoginModel login) throws InvalidLoginException {
		try {
			User user = userDAO.getUserByUserNamePassword(login).get(0);

			UserResponseModel responseModel = new UserResponseModel();
			responseModel.setUserName(user.getUserName());
			responseModel.setInstructor("Instructor".equalsIgnoreCase(user.getRole()));
			return responseModel;
		}catch(Exception e) {
			throw new InvalidLoginException("Invalid username or password!");
		}
	}
}
