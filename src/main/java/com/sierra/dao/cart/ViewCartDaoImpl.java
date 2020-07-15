package com.sierra.dao.cart;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sierra.entity.cart.UserItems;
import com.sierra.entity.cart.UserItemsId;
import com.sierra.entity.upload.ContenTable;
import com.sierra.model.cart.CartModel;
import com.sierra.model.search.SearchResponseModel;

@Repository
@Transactional

public class ViewCartDaoImpl implements ViewCartDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SearchResponseModel> viewCart(CartModel cart) {
		Session session = sessionFactory.getCurrentSession();


		String hql = "from UserItems where userName = :userName";

		Query<UserItems> query = session.createQuery(hql,UserItems.class);
		query.setParameter("userName",cart.getUserName());
		List<UserItems> userItems = query.getResultList();
		List<SearchResponseModel> searchResponses = new ArrayList<>();
		List<Integer> itemIds = new ArrayList<>();
		


		try {
			for(UserItems usersItems : userItems) {
				
				UserItemsId userItemId = usersItems.getUserItems();
				int itemId = userItemId.getItemsId();
				itemIds.add(itemId);
				
				/*items = itemIds.stream().map(iId -> String.valueOf(iId)).collect(Collectors.joining(","));
				System.out.println("Items "+items);*/

			}
		}
		catch(Exception e) {
		}
		if(null !=itemIds && itemIds.size()>0) {
		Query<ContenTable> query_contents = session.createQuery
				("from ContenTable where id in  (:itemIds)",ContenTable.class);
		query_contents.setParameterList("itemIds",itemIds);
		List<ContenTable> contents = query_contents.getResultList();

		try { 
			for(ContenTable content : contents) 
			{ 

				SearchResponseModel searchResponse = new SearchResponseModel(); 
				//byte[] fileBytes =content.getFileBytes(); 
				String fileName = content.getName(); 
				String directory= content.getDirectory(); 
				int item_id = content.getId(); 
				double price =content.getItemPrice(); 
				System.out.println("directory "+directory); 
				File file= new File(directory); 
				//File file = new File("C:/Sierra/videos/"+fileName);
				byte[] fileBytes = Files.readAllBytes(file.toPath());

				// System.out.println(Arrays.toString(fileBytes)); 
				if (null != fileBytes && fileBytes.length > 0) 
				{ 
					String base64Str =
							Base64.getEncoder().encodeToString(fileBytes); 
					//System.out.println(base64Str);
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
			}
		catch(Exception e) {
					e.printStackTrace();
					}

	
		}

	return searchResponses;

}

}
