package com.home.orderservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import commons.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	private static List<Order> orders = new ArrayList<>();
	private static int orderId = 4;

	static {

		Order order1 = new Order(1, "Order 1 ");
		Order order2 = new Order(2, "Order 2 ");
		Order order3 = new Order(3, "Order 3 ");
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);

	}

	@Override
	public Order saveOrder(Order order) {

		if (order.getOrderId() == null) {
			order.setOrderId(++orderId);
		}
		orders.add(order);
		return order;
	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public Order getOrder(Integer orderId) {
		return orders.get(orderId-1);
	}

}
