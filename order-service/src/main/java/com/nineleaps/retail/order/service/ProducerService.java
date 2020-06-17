package com.nineleaps.retail.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
	 private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
	    private static final String TOPIC = "order";

	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

	    public void sendMessage(String message) {
	        this.kafkaTemplate.send(TOPIC, message);
	    }


}
