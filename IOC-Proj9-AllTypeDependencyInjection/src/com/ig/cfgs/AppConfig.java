package com.ig.cfgs;
import java.io.InputStream;
import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.ig.sbeans")
public class AppConfig 
{
	@Bean(name="dt")
	public Scanner scanner(InputStream in)
	{
		return new Scanner(in);
	}
	
	@Bean(name="in")
	public InputStream inputStream()
	{
		return System.in;
	}
}
