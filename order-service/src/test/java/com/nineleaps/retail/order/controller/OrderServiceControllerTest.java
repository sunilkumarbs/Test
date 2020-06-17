package com.nineleaps.retail.order.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.nineleaps.retail.order.entity.OrderEntity;
import com.nineleaps.retail.order.service.OrderService;
import com.nineleaps.retail.order.service.ProducerService;
@RunWith(SpringRunner.class)
public class OrderServiceControllerTest {
	@InjectMocks
	OrderServiceController orderServiceController;
	
	
	@Mock
	OrderService orderService;
	@Mock
	ProducerService producerService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void createOrderTest() {
		OrderEntity orderEntity = new OrderEntity();
		orderServiceController.createOrder(orderEntity);
		
	}	
	
	@Test
	public void getAllOrdersTest() {
		orderServiceController.getAllOrders();
		
	}	
	
	@Test
	public void produceTest() {
		orderServiceController.produce("1234");
		
	}	
	

}
