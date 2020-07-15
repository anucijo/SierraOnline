package com.sierra.service.cart;

import java.util.List;

import com.sierra.model.cart.CartModel;
import com.sierra.model.search.SearchResponseModel;

public interface ViewCartService {
	public List<SearchResponseModel> viewCart(CartModel cart);

}
