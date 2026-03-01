package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Proj02ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj02ConfigServerApplication.class, args);
	}

}
