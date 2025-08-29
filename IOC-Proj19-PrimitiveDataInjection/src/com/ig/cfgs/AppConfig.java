package com.ig.cfgs;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ig.sbeans.DatabaseProperties;

@Configuration
@ComponentScan(basePackages = "com.ig.sbeans")
public class AppConfig 
{
	@Autowired
	private DatabaseProperties dbProp;
	
	@Bean
	public Connection getConnection()
	{
		Connection con = null;
		try
		{
			System.out.println(dbProp.getDbUrl()+" "+dbProp.getUser()+" "+dbProp.getPass());
			con = DriverManager.getConnection(dbProp.getDbUrl(),dbProp.getUser(),dbProp.getPass());
			System.out.println("Welcome, you are connected to database!");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
