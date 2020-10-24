package com.home.orderservice.service;

import java.util.List;

import commons.Order;

public interface OrderService {

	Order saveOrder(Order order);

	List<Order> getOrders();

	Order getOrder(Integer orderId);
}
