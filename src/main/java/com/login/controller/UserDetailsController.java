package com.login.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.login.dao.FileUploadRepository;
import com.login.dao.UserDAO;
import com.login.entity.ContenTable;
import com.login.model.LoginModel;
import com.login.model.SearchResponseModel;
import com.login.model.UserModel;
import com.login.model.UserResponseModel;
import com.login.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserDetailsController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserDAO userDAO;
	@RequestMapping(value ="/addUser", method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> addUser(@RequestBody UserModel user) throws Exception{
		System.out.println("adduser post mapping");
		userService.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value ="/login", method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})

	public ResponseEntity<Object> login(@RequestBody LoginModel login) throws Exception {
		System.out.println("login post mapping");
		UserResponseModel response = userService.getUserByUserNamePassword(login);

		//		UserResponseModel response = new UserResponseModel();
		//		response.setUserName(login.getUserName());
		//		response.setValidUser(true);
		return new ResponseEntity<>(response, HttpStatus.OK);

		//return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
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
		saveContent.setFileBytes(file.getBytes());

		// Save the records into the database
		fileUploadRepository.save(saveContent);

		return "Records saved into database.";
	}

	@GetMapping(value ="/search")
	public List<SearchResponseModel> getVideos(@RequestParam String searchKeyWord) throws Exception {
		//String fileBytes = testVideo();
		//if ("".equals(fileBytes)) {
			return userDAO.getVideos(searchKeyWord);
		/*} else {
			return Collections.singletonList(fileBytes);
		}*/
	}

	private String testVideo() {
		try {
			ClassPathResource lvResource = new ClassPathResource("/assets/Video.mp4");
			File file = lvResource.getFile();
			return Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath()));
		} catch (Exception ex) {
			System.out.println(ex);
			return "";
		}
	}
}


