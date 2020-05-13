package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.login.model.LoginModel;
import com.login.model.UserModel;
import com.login.model.UserResponseModel;
import com.login.service.UserService;

@RestController
public class UserDetailsController {

	@Autowired
	private UserService userService;

	@RequestMapping(value ="/addUser", method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public UserResponseModel addUser(@RequestBody UserModel user) {
		System.out.println("adduser post mapping");

		UserResponseModel response = new UserResponseModel();
		response.setUserName(userService.addUser(user));
		return response;
	}

	@RequestMapping(value ="/login", method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})

	public ResponseEntity<Object> login(@RequestBody LoginModel login) throws Exception {
		System.out.println("login post mapping");
		userService.getUserByUserNamePassword(login);

//		UserResponseModel response = new UserResponseModel();
//		response.setUserName(login.getUserName());
//		response.setValidUser(true);

		return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
	} 
}


