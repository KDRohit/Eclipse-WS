package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
@EnableKafka
public class Proj04KafkaReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj04KafkaReaderApplication.class, args);
	}

}
