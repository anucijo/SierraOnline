package com.sierra.dao.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sierra.entity.cart.UserItems;
import com.sierra.entity.cart.UserItemsId;

@Repository
public interface UsersItemsRepository extends JpaRepository<UserItems, UserItemsId>{

}
