package com.login.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.login.dao.FileUploadRepository;
import com.login.entity.ContenTable;
import com.login.model.LoginModel;
import com.login.model.UserModel;
import com.login.service.UserService;

@RestController
public class UserDetailsController {

	@Autowired
	private UserService userService;

	@RequestMapping(value ="/addUser", method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> addUser(@RequestBody UserModel user) throws Exception{
		System.out.println("adduser post mapping");
		//System.out.println("Service:" + user.getUserName());
		userService.addUser(user);
		return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
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
	
	@Autowired
	private FileUploadRepository fileUploadRepository;

	@PostMapping(value = "/database")
	public String uploadToDatabase(@RequestParam String name, @RequestParam MultipartFile file)
			throws IOException {
		System.out.println("in controller");
		// Set the form data into entity
		ContenTable saveContent = new ContenTable();
		saveContent.setName(name);
		saveContent.setPhoto(file.getBytes());

		// Save the records into the database
		fileUploadRepository.save(saveContent);

		return "Records saved into database.";
	}
}


