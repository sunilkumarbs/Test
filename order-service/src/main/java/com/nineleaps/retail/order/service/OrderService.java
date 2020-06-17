package com.nineleaps.retail.order.service;

import static com.nineleaps.retail.order.util.OrderConstant.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nineleaps.retail.order.entity.OrderEntity;
import com.nineleaps.retail.order.repository.OrderRepository;
import com.nineleaps.retail.order.util.OrderserviceUtil;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProducerService producerService;

	public ResponseEntity<Object> createOrder(OrderEntity orderEntity) {
		Optional<OrderEntity> optional = orderRepository.findById(orderEntity.getId());

		if (optional.isPresent()) {
			return OrderserviceUtil.buildResponse(HttpStatus.FOUND, ORDER_FOUND);
		} else {
			orderRepository.save(orderEntity);
			producerService.sendMessage(Integer.toString(orderEntity.getId()));
			return new ResponseEntity<Object>(orderEntity, HttpStatus.CREATED);
		}

	}

	public ResponseEntity<Object> getAllOrders() {
		return new ResponseEntity<Object>(orderRepository.findAll(),HttpStatus.OK);
	}

}
