package com.nineleaps.retail.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nineleaps.retail.order.entity.OrderEntity;
import com.nineleaps.retail.order.service.OrderService;
import com.nineleaps.retail.order.service.ProducerService;

@RestController
@RequestMapping(value = "/retail-shop")
public class OrderServiceController {

	@Autowired
	OrderService orderService;

	@Autowired
	ProducerService producerService;

	@PostMapping(value = "/orders")
	public ResponseEntity<Object> createOrder(@RequestBody OrderEntity orderEntity) {
		return orderService.createOrder(orderEntity);
	}

	@GetMapping(value = "/orders")
	public ResponseEntity<Object> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> produce(@PathVariable String id) {
		producerService.sendMessage(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
