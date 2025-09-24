package com.ig.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static Connection con = null;
	
	static 
	{
		try
		{
			Class.forName(DBInfo.driverName);
			con = DriverManager.getConnection(DBInfo.dbUrl, DBInfo.dbuser, DBInfo.dbPass);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		try
		{
			Class.forName(DBInfo.driverName);
			con = DriverManager.getConnection(DBInfo.dbUrl, DBInfo.dbuser, DBInfo.dbPass);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
