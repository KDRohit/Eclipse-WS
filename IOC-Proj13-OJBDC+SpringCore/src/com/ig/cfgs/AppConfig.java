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
		System.out.println("Connecting...");
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost/freepdb1";
		String user = "system";
		String password = "manager";
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to the Database");
		return connection;
	}
	
	@Bean(name="createStatement")
	public Statement createStatement() throws Exception
	{
		return connection.createStatement();
	}
}
