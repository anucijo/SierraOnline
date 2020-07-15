package com.sierra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sierra.model.admin.UserModel;
import com.sierra.service.admin.UserDetailsService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminController {
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping(value ="/instructors")
	public List<UserModel> getInstructorDetails() {
		return userDetailsService.getUserDetailsByRole("instructor");
		
		
	}
	@GetMapping(value ="/students")
	public List<UserModel> getStudentDetails() {
		return userDetailsService.getUserDetailsByRole("student");
		
		
	}
	

}
