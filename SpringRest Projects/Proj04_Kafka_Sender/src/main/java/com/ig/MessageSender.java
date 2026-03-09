package com.ig;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageSender 
{
		@Autowired
		 private KafkaTemplate<String, String> kafkaTemplate;
		
		@Value("${app.topic.name}")
		private String topicName;
		
		@Scheduled(cron = "59 * * * * *")
		public void SendMessageOn59thSecond()
		{
			int randNum =new Random().nextInt(10);
			System.out.println("Send:: Random Number :: "+randNum);
			kafkaTemplate.send(topicName,"Random Number :: "+randNum);
			log.info("-------------NEW MESSAGE SENT------------");
			log.warn("TOPIC NAME::"+topicName+", MESSAGE::Random Number :: "+randNum);
		}
}
