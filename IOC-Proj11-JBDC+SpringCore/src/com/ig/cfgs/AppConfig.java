package com.ig.cfgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.ig.db")

public class AppConfig 
{
	Connection connection;
	
	@Bean(name="scanner")
	public Scanner scanner()
	{
		return new Scanner(System.in);
	}
	
	@Bean(name="connection")
	public Connection connection() throws Exception
	{
		String url = "jdbc:mysql://localhost/ingenuity";
		String user = "root";
		String password = "1234";
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	@Bean(name="createStatement")
	public Statement createStatement() throws Exception
	{
		return connection.createStatement();
	}
}
