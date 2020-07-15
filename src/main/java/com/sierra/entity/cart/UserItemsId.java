package com.sierra.entity.cart;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserItemsId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6016724634756979936L;
	private String userName;
	private int itemsId;



	public UserItemsId() {

	}
	public UserItemsId(String userName, int itemsId) {
		super();
		this.userName = userName;
		this.itemsId = itemsId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getItemsId() {
		return itemsId;
	}
	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemsId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserItemsId other = (UserItemsId) obj;
		if (itemsId != other.itemsId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


}
