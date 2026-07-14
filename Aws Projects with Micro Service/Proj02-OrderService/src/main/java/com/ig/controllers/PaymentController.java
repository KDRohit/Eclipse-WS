package com.ig.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.events.Event;
import com.ig.events.PaymentEvent;

@RestController
@RequestMapping("/payment-service")
public class PaymentController 
{
	@Autowired
	KafkaTemplate<String, Event> kafkaTemplate;
	
	@GetMapping("/buy/{item}/{amount}")
	public void doPayment(@PathVariable String item,@PathVariable Integer amount)
	{
		PaymentEvent event = new PaymentEvent();
		event.id=UUID.randomUUID().toString();
		event.amount=amount;
		event.status="success";
		kafkaTemplate.send("payment-event",event);
	}
}
