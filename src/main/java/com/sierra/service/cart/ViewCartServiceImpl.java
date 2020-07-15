package com.sierra.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierra.dao.cart.ViewCartDao;
import com.sierra.model.cart.CartModel;
import com.sierra.model.search.SearchResponseModel;


@Service
public class ViewCartServiceImpl implements ViewCartService {
	
@Autowired
ViewCartDao viewCartDao;
	
	@Override
	public List<SearchResponseModel> viewCart(CartModel cart) {
		
		return viewCartDao.viewCart(cart);
		
	}

	
}
