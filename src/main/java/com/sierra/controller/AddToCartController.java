package com.sierra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sierra.model.cart.CartModel;
import com.sierra.model.login.UserModel;
import com.sierra.model.search.SearchResponseModel;
import com.sierra.service.cart.AddtoCartService;
import com.sierra.service.cart.ViewCartService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AddToCartController {
	@Autowired
	AddtoCartService addToCartService;
	@Autowired
	ViewCartService viewCartService;
	
	@RequestMapping(value ="/addToCart", method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> addToCart(@RequestBody CartModel cart) throws Exception{
		System.out.println("adduser post mapping");
		int orderId = addToCartService.addToOrderItems(cart);
		return new ResponseEntity<>(orderId, HttpStatus.OK);
	}
	@RequestMapping(value ="/viewCart", method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public List<SearchResponseModel> viewCart(@RequestBody CartModel cart) throws Exception{
		System.out.println("adduser post mapping");
		
		return viewCartService.viewCart(cart);
	}
}
