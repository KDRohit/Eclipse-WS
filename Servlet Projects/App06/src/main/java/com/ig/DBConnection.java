package com.ig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static Connection con = null;
	
	static 
	{
		try
		{
			con = DriverManager.getConnection(DBInfo.dbUrl, DBInfo.dbuser, DBInfo.dbPass);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		return con;
	}
}
