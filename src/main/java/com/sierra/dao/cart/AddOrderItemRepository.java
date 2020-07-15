package com.sierra.dao.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sierra.entity.cart.OrderItems;
import com.sierra.entity.cart.Orders;

@Repository
public interface AddOrderItemRepository extends JpaRepository<OrderItems, Integer>{ 

}
