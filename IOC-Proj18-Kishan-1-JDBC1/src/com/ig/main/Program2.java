package com.ig.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Program2 
{
	public String driver = "mysql.jdbc.DriverManager";
	public String dbUrl = "jdbc:mysql://localhost/ingenuity";
	public String user = "root";
	public String pass = "1234";
	
	public Scanner sc = new Scanner(System.in);
	public Connection con = null;
	
	public Connection getConnection()
	{
		try
		{
			if(con==null || con.isClosed())
			{
				con =  DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Connection created successfully");
			}
			else
			{
				System.out.println("Connection already created");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public void createTable()
	{
		System.out.println("Enter table name:-");
		String tableName =  sc.nextLine();
		Connection con =  getConnection();
		try
		{
			Statement st = con.createStatement();
			int rows = st.executeUpdate("create table "+tableName+"(bookId int, bookName varchar(40), author varchar(40), Genere varchar(40), cost int)");
			if(rows==0)
			{
				System.out.println("Table "+tableName+" created successfully");
			}
			else
			{
				System.out.println(" Failed to create Table "+tableName);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		showEndMessage();
		manageLibrary();
	}
	
	public void retrieveData()
	{
		System.out.println("Enter table name:-");
		String tableName =  sc.nextLine();
		Connection con =  getConnection();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+tableName);
			while(rs.next())
			{
				int rows = rs.getMetaData().getColumnCount();
				for(int i=1;i<=rows;i++)
				{
					System.out.print(rs.getObject(i)+" ");
				}
				System.out.println();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		showEndMessage();
		manageLibrary();
	}
	
	public void insertIntoTable()
	{
		System.out.println("Enter table name:-");
		String tableName =  sc.nextLine();
		System.out.println("Enter book Id:-");
		int bookId =  Integer.parseInt(sc.nextLine());
		System.out.println("Enter book Name:-");
		String bookName =  sc.nextLine();
		System.out.println("Enter author name:-");
		String author =  sc.nextLine();
		System.out.println("Enter book Genre:-");
		String genre =  sc.nextLine();
		System.out.println("Enter book cose:-");
		Integer bookCost =  Integer.parseInt(sc.nextLine());
		
		Connection con =  getConnection();
		try
		{
			Statement st = con.createStatement();
			int rows = st.executeUpdate("insert into "+tableName+" values ("+bookId+",'"+bookName+"','"+author+"','"+genre+"',"+bookCost+")");
			if(rows==1)
			{
				System.out.println("Values inserted into "+tableName+" successfully");
			}
			else
			{
				System.out.println(" Failed to insert into Table "+tableName);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		showEndMessage();
		manageLibrary();
	}
	
	public void deleteFromTable()
	{
		System.out.println("Enter table name:-");
		String tableName =  sc.nextLine();
		System.out.println("Enter book id which you want to delete");
		int bookId =  Integer.parseInt(sc.nextLine());
		Connection con =  getConnection();
		try
		{
			Statement st = con.createStatement();
			int rows = st.executeUpdate("delete from "+tableName+" where bookid="+bookId);
			if(rows==1)
			{
				System.out.println("Table "+tableName+" udpated successfully");
			}
			else
			{
				System.out.println(" Failed to update Table "+tableName);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		showEndMessage();
		manageLibrary();
	}
	
	public void showEndMessage()
	{
		System.out.println("--------------------");
		System.out.println("execution completed");
		System.out.println();
		System.out.println();
		System.out.println("execution started");
		System.out.println("--------------------");
	}
	public void manageLibrary()
	{
		System.out.println("Enter Number 1-4");
		System.out.println("Create Table:-1");
		System.out.println("Retrive From Table:-2");
		System.out.println("Insert Into Table:-3");
		System.out.println("Delete From Table:-4");
		System.out.println("Exit:-5");
		int num = Integer.parseInt(sc.nextLine());
		switch (num) 
		{
		case 1:
			createTable();
			break;
		case 2:
			retrieveData();
			break;
		case 3:
			insertIntoTable();
			break;
		case 4:
			deleteFromTable();
			break;
		default :
			System.out.println("bye!!!");
			System.exit(1);
			break;
		}
	}
	
	public static void main(String[] args) 
	{
		new Program2().manageLibrary();
	}
}
