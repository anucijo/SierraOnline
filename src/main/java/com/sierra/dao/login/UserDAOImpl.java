package com.sierra.dao.login;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exception.InvalidLoginException;
import com.sierra.entity.login.User;
import com.sierra.entity.upload.ContenTable;
import com.sierra.model.login.LoginModel;
import com.sierra.model.search.SearchResponseModel;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<User> getUserByUserNamePassword(LoginModel login) throws InvalidLoginException {
		System.out.println("Inside DAO login username"+login.getUserName()+login.getPassword());	

		Query<User> query=sessionFactory.getCurrentSession()
				.createQuery("from User where username=:userName and password=:passWord", User.class);
		query.setParameter("userName", login.getUserName());
		query.setParameter("passWord", login.getPassword());

		List<User> list=query.getResultList();
		if(null == list || list.isEmpty()) {
			throw new InvalidLoginException("Invalid login");
		}
		return list;
	}

	public List<SearchResponseModel> getVideos(String searchKeyWord)  {
		Session session = sessionFactory.getCurrentSession();
		Query<ContenTable> query = session.createQuery("from ContenTable where name like '%"+searchKeyWord+"%'",ContenTable.class);
		List<ContenTable> contents = query.getResultList();

		List<SearchResponseModel> searchResponses = new ArrayList<>();
		try {
		for(ContenTable content : contents) {
			SearchResponseModel searchResponse = new SearchResponseModel();
			//byte[] fileBytes = content.getFileBytes();
			String fileName = content.getName();
			String directory = content.getDirectory();
			int item_id = content.getId();
			double price = content.getItemPrice();
			System.out.println("directory "+directory);
			File file = new File(directory);
			//File file = new File("C:/Sierra/videos/"+fileName);
			byte[] fileBytes = Files.readAllBytes(file.toPath());
			
			// System.out.println(Arrays.toString(fileBytes));
			if (null != fileBytes && fileBytes.length > 0) {
				String base64Str = Base64.getEncoder().encodeToString(fileBytes);
				// System.out.println(base64Str);
				searchResponse.setVideoName(fileName);
				searchResponse.setVideoBytes(base64Str);
				searchResponse.setItem_id(item_id);
				searchResponse.setPrice(price);
				searchResponses.add(searchResponse);
			}
		}

		if(null == searchResponses || searchResponses.isEmpty()) {
		   System.out.println("No results");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return searchResponses;
	}


}
