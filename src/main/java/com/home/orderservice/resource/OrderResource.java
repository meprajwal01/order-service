package com.home.orderservice.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.home.orderservice.service.OrderService;

import commons.Order;

@RestController
public class OrderResource {

	//@Autowired
	//private KafkaTemplate<String, Order> kafkaTemplate;

	@Autowired
	private OrderService orderService;

	private final String TOPIC_NAME = "order_topic";

	@GetMapping(value = "/orders")
	public List<Order> getOrders() {
		return orderService.getOrders();
	}

	@GetMapping(value = "/order/{orderId}")
	public Order getOrders(@PathVariable Integer orderId) {
		return orderService.getOrder(orderId);
	}

	@PostMapping(value = "/order")
	public ResponseEntity<Object> order(@RequestBody Order order) {

		Order savedOrder = orderService.saveOrder(order);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrder.getOrderId())
				.toUri();

		//kafkaTemplate.send(TOPIC_NAME, savedOrder);
		return ResponseEntity.created(uri).build();
	}
}
