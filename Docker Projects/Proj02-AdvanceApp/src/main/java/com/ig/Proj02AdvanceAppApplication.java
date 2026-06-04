package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Proj02AdvanceAppApplication 
{
	public static void main(String[] args)
	{
		SpringApplication.run(Proj02AdvanceAppApplication.class, args);
	}
}
