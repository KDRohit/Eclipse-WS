package com.ig;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageListner 
{
	@KafkaListener(topics = "${app.topic.name}",groupId = "grp1")
	public void messageLisner(String message)
	{
		System.out.println("New Message is Received :: "+message);
		log.info("-----------NEW MESSAGE LISTNED-----------");
		log.warn("New Message is Received :: "+message);
	}
}
