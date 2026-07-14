package com.ig.listners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ig.events.InventoryEvent;
import com.ig.events.OrderEvent;
import com.ig.events.PaymentEvent;

@Component
public class EventLisner 
{
	@KafkaListener(topics = "inventory-event",groupId = "grp_customer")
	public void InventoryEventListned(InventoryEvent e)
	{
		System.out.println(e);
	}
	
	@KafkaListener(topics = "order-event",groupId = "grp_customer")
	public void OrderEventListned(OrderEvent e)
	{
		System.out.println(e);
	}
	
	@KafkaListener(topics = "payment-event",groupId = "grp_customer")
	public void PaymentEventListned(PaymentEvent e)
	{
		System.out.println(e);
	}
}
