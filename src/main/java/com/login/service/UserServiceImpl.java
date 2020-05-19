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
import com.login.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(UserModel usermodel) throws DuplicateUserNameException  {
		try {
			System.out.println("Service");
			User user = new User();
			user.setFirstName(usermodel.getFirstName());
			user.setLastName(usermodel.getLastName());
			user.setPassword(usermodel.getPassword());
			user.setRole(usermodel.getRole());
			System.out.println("Service:" + usermodel.getUserName());
			user.setUserName(usermodel.getUserName());	
			userDAO.addUser(user);
			System.out.println("After Service");
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new DuplicateUserNameException("Duplicate UserName");
		}catch(Exception e) {
			e.printStackTrace();
			throw new DuplicateUserNameException("Duplicate UserName11111");
			//e.printStackTrace();
		}
	}

	@Override
	public void getUserByUserNamePassword(LoginModel login) throws InvalidLoginException {
		userDAO.getUserByUserNamePassword(login);
	}
}
