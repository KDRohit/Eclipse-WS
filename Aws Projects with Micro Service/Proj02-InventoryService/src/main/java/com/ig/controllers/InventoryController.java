package com.ig.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ig.events.Event;

@RestController
@RequestMapping("/inventory-service")
public class InventoryController 
{
	@Autowired
	KafkaTemplate<String, Event> kafkaTemplate;
	
	
	@GetMapping("/add/{id}")
	public void addToCart(@PathVariable String id)
	{
		
	}
}
