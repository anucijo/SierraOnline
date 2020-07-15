package com.sierra.dao.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sierra.entity.cart.Orders;

@Repository
public interface AddToCartRepository extends JpaRepository<Orders, Integer>{
	 Orders findByOrderId(int orderId);	
}
