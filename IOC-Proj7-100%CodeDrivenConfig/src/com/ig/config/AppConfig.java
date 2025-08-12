package com.ig.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ig.sbeans")
public class AppConfig 
{
	@Bean
	public LocalDateTime getLocalDateTime()
	{
		return LocalDateTime.now();
	}
}
