package com.sierra.entity.cart;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int orderId;

	@OneToMany(mappedBy="orders" ,cascade= CascadeType.ALL)
	private List<OrderItems> lOrderItems; 
	
	@Column
	private String userName;
	@Column
	private Date orderDate;
	@Column
	private double orderTotal;
	
	private String statusCode;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public List<OrderItems> getlOrderItems() {
		return lOrderItems;
	}
	public void setlOrderItems(List<OrderItems> lOrderItems) {
		this.lOrderItems = lOrderItems;
	}

}
