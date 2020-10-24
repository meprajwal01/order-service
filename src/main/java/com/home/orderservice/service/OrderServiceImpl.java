package com.home.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.orderservice.dao.OrderDao;
import com.home.orderservice.exception.OrderException;
import com.home.orderservice.exception.OrderNotFoundException;

import commons.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public Order saveOrder(Order order) {
		return orderDao.saveOrder(order);
	}

	@Override
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}

	@Override
	public Order getOrder(Integer orderId) {

		Order order = orderDao.getOrder(orderId);
		if (order == null)
			throw new OrderNotFoundException(orderId.toString());
		return order;
	}

}
