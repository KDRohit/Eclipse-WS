package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager
{
	private static final String driverClassPath = "com.mysql.cj.jdbc.Driver";
	private static final String dbUrl  = "jdbc:mysql://localhost/ingenuity";
	private static final String dbUser = "root";
	private static final String dbPass = "1234";
	
	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName(driverClassPath);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
