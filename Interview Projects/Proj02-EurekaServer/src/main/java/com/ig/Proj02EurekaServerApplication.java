package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Proj02EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj02EurekaServerApplication.class, args);
	}

}
