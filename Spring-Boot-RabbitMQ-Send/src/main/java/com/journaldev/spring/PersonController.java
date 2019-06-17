package com.journaldev.spring;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@EnableJms
@RestController
public class PersonController {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	private String rabbitExchange = "VasuExchange";
	
	private String rabbitRoutingKey = "VQ1";
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot REST...";
	}
	
	@RequestMapping("/sendMessageToRabbitMq/{message}")
	public String sendMessageToRabbitMq(@PathVariable("message") String message) {
		rabbitTemplate.convertAndSend(rabbitExchange, rabbitRoutingKey, message);
		return "Message is sent to RabbitMQ successfully...";
	}
	
}
