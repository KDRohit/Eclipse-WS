package com.ig.listners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ig.events.InventoryEvent;
import com.ig.events.OrderEvent;
import com.ig.events.PaymentEvent;

@Component
public class EventLisner 
{
	@KafkaListener(topics = "inventory-event",groupId = "grp_1")
	public void InventoryEventListned(InventoryEvent e)
	{
		
	}
	
	@KafkaListener(topics = "order-event",groupId = "grp_1")
	public void OrderEventListned(OrderEvent e)
	{
		
	}
	
	@KafkaListener(topics = "payment-event",groupId = "grp_1")
	public void PaymentEventListned(PaymentEvent e)
	{
		
	}
}
