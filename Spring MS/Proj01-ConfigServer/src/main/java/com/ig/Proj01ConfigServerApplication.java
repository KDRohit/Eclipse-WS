package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Proj01ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj01ConfigServerApplication.class, args);
	}

}
