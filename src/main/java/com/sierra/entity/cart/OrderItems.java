package com.sierra.entity.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemsId;
	@Column
	private int itemId;
	@Column
	private double itemPrice;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Orders orders;

	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public int getOrderItemsId() {
		return orderItemsId;
	}
	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	

}
