package com.ig.cfgs;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages="com.ig.sbeans")
public class AppConfig 
{
	public AppConfig()
	{
		System.out.println("AppConfig.AppConfig() with 0 param constructor invoked");
	}
	
	@Bean(name = "currentThreadName1")
	public String getCurrentThreadName1()
	{
		System.out.println("AppConfig.getCurrentThreadName() with 0 param method invoked");
		return Thread.currentThread().getName()+" 1";
	}
	
	@Bean(name = "currentThreadName2")
	public String getCurrentThreadName2()
	{
		System.out.println("AppConfig.getCurrentThreadName() with 0 param method invoked");
		return Thread.currentThread().getName()+" 2";
	}
	
	/*@Bean(name="sc1")
	public Scanner scanner(InputStream in)
	{
		System.out.println("AppConfig.scanner() invoked");
		return new Scanner(in);
	}
	
	@Bean(name="in1")
	public InputStream inputStream()
	{
		System.out.println("AppConfig.inputStream() invoked");
		return System.in;
	}*/
}
