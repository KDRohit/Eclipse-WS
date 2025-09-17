package com.ig.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BatchProcessingProgram 
{
	private String driverUrl="com.mysql.cj.jdbc.Driver";
	private String dbUrl="jdbc:mysql://localhost/ingenuity";
	private String dbUser="root";
	private String dbPass="1234";
	private Scanner sc = new Scanner(System.in);
	
	Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName(driverUrl);
			con =  DriverManager.getConnection(dbUrl, dbUser, dbPass);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Connected to the db successfully!!!");
		return con;
	}
	
	void meth1()
	{
		System.out.println("Implementing Batch Processing\n");
		Connection con = getConnection();
		try
		{
			Statement stmt =  con.createStatement();
			System.out.println("How many queries you want to enter?");
			int no_of_queries = Integer.parseInt(sc.nextLine()) ;
			for( int i=1;i<no_of_queries ;i++ )
			{
				System.out.println("Enter your "+i+" query");
				stmt.addBatch(sc.nextLine());
			}
			int[] arr =  stmt.executeBatch();
			for(int rowCount : arr)
			{
				System.out.println("======>"+rowCount+"<======");
			}
			stmt.clearBatch();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) 
	{
		BatchProcessingProgram batchPro = new  BatchProcessingProgram();
		batchPro.meth1();
	}
}
