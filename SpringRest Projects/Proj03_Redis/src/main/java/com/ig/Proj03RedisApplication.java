package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Proj03RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj03RedisApplication.class, args);
	}

}
