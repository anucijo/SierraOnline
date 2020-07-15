package com.sierra.service.cart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierra.dao.cart.AddOrderItemRepository;
import com.sierra.dao.cart.AddToCartRepository;
import com.sierra.dao.cart.UsersItemsRepository;
import com.sierra.entity.cart.OrderItems;
import com.sierra.entity.cart.Orders;
import com.sierra.entity.cart.UserItems;
import com.sierra.entity.cart.UserItemsId;
import com.sierra.model.cart.CartModel;
@Service
public class AddtoCartServiceImpl implements AddtoCartService{

	@Autowired
	private AddToCartRepository addToCartDao;

	@Autowired
	private AddOrderItemRepository addOrderItemDao;
	
	@Autowired
	private UsersItemsRepository usersItemsRepository;
	@Override
	public int addToOrderItems(CartModel cart) {
		// TODO Retrieve existing order and add items to it
		Orders orders = null;	
		//List<OrderItems> lOrderItems = null;

		if (null == cart.getOrderId()) {
			orders = createNewOrder(cart);
		} else {
			// TODO fetch order details
			orders = addToCartDao.findByOrderId(cart.getOrderId());
			if (null == orders) {
				orders = createNewOrder(cart);
			}
		}	


		OrderItems orderItem = createNewOrderItem(cart,orders);
		orders.setOrderTotal(calculateTotalOrderPrice(orderItem,orders));

		orders = addToCartDao.save(orders);
		System.out.println("orders "+orders.getOrderId());
		int orderId = orders.getOrderId();
		addOrderItemDao.save(orderItem);
		
		//insert the items in UserItems
		addToUserItems(cart.getItem_id(),cart.getUserName());
		
		return orderId;
	}

	private void addToUserItems(int item_id, String userName) {
		UserItemsId userItemsId = new UserItemsId();
		userItemsId.setItemsId(item_id);
		userItemsId.setUserName(userName);
		UserItems userItems = new UserItems();
		userItems.setUserItems(userItemsId);
		usersItemsRepository.save(userItems);
		
		
	}

	private Orders createNewOrder(CartModel cart) {
		Orders orders = new Orders();
		orders.setUserName(cart.getUserName());
		orders.setStatusCode("C");
		orders.setOrderDate(new Date());
		return orders;
	}

	private OrderItems createNewOrderItem(CartModel cart, Orders orders) {
		OrderItems orderItems = new OrderItems();
		orderItems.setItemId(cart.getItem_id());
		orderItems.setItemPrice(cart.getPrice());
		orderItems.setOrders(orders);
		return orderItems;
		/*List<OrderItems> lOrderItems = new ArrayList<>();
		lOrderItems.add(orderItems);
		return lOrderItems;*/

	}

	private double calculateTotalOrderPrice(OrderItems orderItems,Orders orders) {
		/*BigDecimal priceTotal = lOrderItems.stream().map(orderItem -> new BigDecimal(orderItem.getItemPrice()))
		.reduce(BigDecimal::add).orElse(new BigDecimal(0.0));
		 */
		//double sum = items.stream().mapToDouble(Item::getPrice).sum();
		double orderPrice = orders.getOrderTotal()+orderItems.getItemPrice();
		//double orderPrice = lOrderItems.stream().mapToDouble(OrderItems ::getItemPrice).sum();
		return orderPrice;
	}

}
