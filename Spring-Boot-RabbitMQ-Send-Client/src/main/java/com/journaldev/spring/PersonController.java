package com.journaldev.spring;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String sendMessageToRabbitMq() {
		String uri = "";
		String result = "";
		long lStartTime = System.currentTimeMillis();
		for(int i=1; i<=1000000; i++) {
			uri = "http://localhost:8081/sendMessageToRabbitMq/Message "+i;
			result = restTemplate.getForObject(uri, String.class);
		}
		long lEndTime = System.currentTimeMillis();
		long output = lEndTime - lStartTime;
		System.out.println("Time taken in milliseconds: " + output);
		return "Messages are sent to RabbitMQ successfully...";
	}
	
}
