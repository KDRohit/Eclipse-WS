package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Proj01FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj01FeignClientApplication.class, args);
	}

}
