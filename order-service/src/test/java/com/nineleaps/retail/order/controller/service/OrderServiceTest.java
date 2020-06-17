package com.nineleaps.retail.order.controller.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.nineleaps.retail.order.entity.OrderEntity;
import com.nineleaps.retail.order.repository.OrderRepository;
import com.nineleaps.retail.order.service.OrderService;
import com.nineleaps.retail.order.service.ProducerService;

@RunWith(SpringRunner.class)
public class OrderServiceTest {
	@InjectMocks
	OrderService orderService;

	@Mock
	OrderRepository orderRepository;

	@Mock
	ProducerService producerService;

	@Test
	public void createOrderTest() {
		Mockito.when(orderRepository.findById(1)).thenReturn(null);
		Mockito.doNothing().when(producerService).sendMessage(Mockito.anyString());
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(3);
		orderService.createOrder(orderEntity);

		Optional<OrderEntity> optional = Optional.of(new OrderEntity());
		Mockito.when(orderRepository.findById(3)).thenReturn(optional);
		orderService.createOrder(orderEntity);

	}
	
	@Test
	public void getAllOrdersTest() {
		orderService.getAllOrders();
		
	}

}
