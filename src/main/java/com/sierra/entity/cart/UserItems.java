package com.sierra.entity.cart;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UserItems {
	@EmbeddedId
	private UserItemsId userItems;

	public UserItems(UserItemsId userItems) {
		super();
		this.userItems = userItems;
	}

	public UserItems() {
		
		
	}

	public UserItemsId getUserItems() {
		return userItems;
	}

	public void setUserItems(UserItemsId userItems) {
		this.userItems = userItems;
	}
	

}
