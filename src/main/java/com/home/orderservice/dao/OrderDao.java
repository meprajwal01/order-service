package com.home.orderservice.dao;

import java.util.List;

import commons.Order;

public interface OrderDao {

	Order saveOrder(Order order);

	List<Order> getOrders();
	
	Order getOrder(Integer orderId);

}
