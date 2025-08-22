package com.ig.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dbManager")
public class DBManager 
{
	@Autowired
	private Scanner scanner;
	@Autowired
	private Connection connection;
	
	@Autowired
	@Qualifier("createStatement")
	private Statement statement;
	
	public int getDBOption()
	{
		System.out.println("Enter Option:-"
				+ "\n 1- Create Table "
				+ "\n 2- Insert Value Into Table "
				+ "\n 3- Select Values From Table "
				+ "\n 4- Delete Table");
		int opt = Integer.parseInt(scanner.nextLine());
		return opt;
	}
	
	public void CreateTable()
	{
		try 
		{
			String query = "";
			System.out.println("Enter Table Name");
			String tbName = scanner.nextLine();
			query+="CREATE TABLE "+tbName+"(";
			System.out.println("Enter how many columns(fields) you need ?");
			int culumns = Integer.parseInt(scanner.nextLine());
			for(int i=1;i<=culumns;i++)
			{
				System.out.println("Enter culumn name:- "+(i));
				String fieldName = scanner.nextLine();
				query+= fieldName+" VARCHAR2(50) NOT NULL";
				String separator = i<culumns?", ":"";
				query+=separator;
			}
			query+= ")";
			System.out.println(query);
			int rows = statement.executeUpdate(query);
			System.out.println("✅ Table "+tbName+" Created Successfully in MySQL!");
			System.out.println(rows + " row(s) inserted successfully!");
			statement.close();
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteTable()
	{
		try 
		{
			String query = "";
			System.out.println("Enter Table Name");
			String tbName = scanner.nextLine();
			query+="DROP TABLE "+tbName;
			int rows = statement.executeUpdate(query);
			System.out.println("✅ Table "+tbName+" Deleted Successfully from MySQL!");
			System.out.println(rows + " row(s) inserted successfully!");
			statement.close();
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void insertIntoTable()
	{
		try 
		{
			String query = "";
			System.out.println("Enter Table Name");
			String tbName = scanner.nextLine();
			query+="INSERT INTO "+tbName+" values (";
			System.out.println("Enter how many columns(fields) you want to insert?");
			int culumns = Integer.parseInt(scanner.nextLine());
			
			String[] values = new String[culumns];
			
			for(int i=1;i<=culumns;i++)
			{
				System.out.println("Enter value:- "+(i));
				String value = scanner.nextLine();
				values[i-1]=value;
				query+= "?";
				String separator = i<culumns?", ":"";
				query+=separator;
			}
			query+= ")";
			System.out.println(query);
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			for(int i=1;i<=culumns;i++)
			{
				prepareStatement.setString(i, values[i-1]);
			}
			int rows = prepareStatement.executeUpdate();
	        System.out.println(rows + " row(s) inserted successfully!");
	        prepareStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void getDataFromTable()
	{
		try 
		{
			String query = "";
			System.out.println("Enter Table Name");
			String tbName = scanner.nextLine();
			query+="SELECT * FROM "+tbName+"";
			ResultSet result =  statement.executeQuery(query);
			while(result.next())
			{
				String projName = result.getString("proj_name");
				String projDev = result.getString("proj_dev");
				System.out.println("proj_name: "+projName+", proj_dev: "+projDev);
			}
			statement.close();
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
