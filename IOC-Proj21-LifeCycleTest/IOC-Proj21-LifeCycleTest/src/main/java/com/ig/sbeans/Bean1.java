package com.ig.sbeans;

import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("b1")
@Data
public class Bean1 
{
	@Value("${emp.name}")
	private String name;
	@Value("${emp.age}")
	private Integer age;
	@Value("${emp.ms}")
	private Boolean isMarried;
	
	@Bean(name="sc")
	private void beanScanner()
	{
		System.out.println("called bean method inside component");
	}
	
	@PostConstruct
	private void customInit()
	{
		System.out.println("called customInit() by ioc container");
	}
	
	@PreDestroy
	private void customDestroy()
	{
		System.out.println("called customDestroy() by ioc container");
	}
}
