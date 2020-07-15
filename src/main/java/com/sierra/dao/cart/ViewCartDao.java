package com.sierra.dao.cart;

import java.util.List;

import com.sierra.model.cart.CartModel;
import com.sierra.model.search.SearchResponseModel;

public interface ViewCartDao {
	public List<SearchResponseModel> viewCart(CartModel cart);

}
