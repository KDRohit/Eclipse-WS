package com.ig.config;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration 
// 1- it will mark this class as config class (nothing but as special bean class)
//		- all @Bean annotated method and life cycle method such as @Configuration(initMethod = "customInit", destroyMethod = "customDestroy") will be invoked


@ComponentScan(basePackages = {"com.ig.sbeans","com.gi.sbeans"}) 
// 1-  this will create all classes object that is marked as @Component annotation

public class AppConfig 
{
	@Bean("ldt")
	public LocalDateTime getLocalDateTime()
	{
		System.out.println("AppConfig.getLocalDateTime()");
		return LocalDateTime.now();
	}
	@Bean("ldt2")
	public LocalDateTime getLocalDateTime1()
	{
		System.out.println("AppConfig.getLocalDateTime1()");
		return LocalDateTime.now();
	}
	
	@Bean
	public Scanner getScanner()
	{
		return new Scanner(System.in);
	}
}
