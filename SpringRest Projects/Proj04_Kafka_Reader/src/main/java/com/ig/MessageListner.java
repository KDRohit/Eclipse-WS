package com.ig;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListner 
{
	@KafkaListener(topics = "${app.topic.name}",groupId = "grp1")
	public void messageLisner(String message)
	{
		System.out.println("New Message is Received :: "+message);
	}
}
