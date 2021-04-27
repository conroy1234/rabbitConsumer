package org.rabbit.consumer.rabbitConsumer.service;

import org.rabbit.consumer.rabbitConsumer.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeProducer {
	
	Logger logger = LoggerFactory.getLogger(EmployeeProducer.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	ObjectMapper mapper = new ObjectMapper();
	
	public void sendMessage(String location, String exchangeKey,Employee employee) throws JsonProcessingException {
		
		String message = mapper.writeValueAsString(employee);
		
		rabbitTemplate.convertAndSend(location,exchangeKey,message);
		
	}

}
