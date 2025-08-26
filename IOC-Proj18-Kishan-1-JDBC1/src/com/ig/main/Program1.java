package com.ig.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class Program1 
{
	public String driver = "mysql.jdbc.DriverManager";
	public String dbUrl = "jdbc:mysql://localhost/ingenuity";
	public String user = "root";
	public String pass = "1234";
	
	Scanner sc = new Scanner(System.in);
	String sqlQuery1 = "select * from ";
	String sqlQuery2 = "insert into developers values ('4','raju')";
	String sqlQuery3 = "select * from developers where emp_id=''";
	String sqlQuery4 = "update developers set emp_name='updated' where emp_id=''";
	
	
	Connection getConnection()
	{
		Connection con = null;
		try
		{
			//Class.forName(driver);
			con = DriverManager.getConnection(dbUrl,user,pass);
			System.out.println("connection created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	void retriveData()
	{
		System.out.println("Retrieving data from the table");
		System.out.println("Enter table name");
		String tableName = sc.nextLine();
		Connection con = getConnection();
		try
		{
			Statement statement =  con.createStatement();
			ResultSet res =  statement.executeQuery(sqlQuery1.concat(tableName));
			while(res.next())
			{
				int count =  res.getMetaData().getColumnCount();
				for(int i=1;i<=count;i++)
				{
					System.out.print(res.getObject(i)+" ");
				}
				System.out.println();
			}
			System.out.println("\ndata retrieved successfully");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void insertDataIntoTable()
	{
		System.out.println("Entering data into table\n ");
		System.out.println("Enter emp id");
		int empId = Integer.parseInt(sc.nextLine());
		System.out.println("Enter emp name");
		String empName = sc.nextLine();
		
		try
		{
			Connection con = getConnection();
			Statement st =  con.createStatement();
			int rows =  st.executeUpdate("insert into developers values ('"+empId+"','"+empName+"')");
			if(rows==1)
			{
				System.out.println("Data inserted successfully");
				System.out.println("Do you want to view the data (yes/no)");
				if(sc.nextLine().equalsIgnoreCase("yes"))
					retriveData();
				else
					System.exit(0);
			}
			
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void retriveSomeData()
	{
		System.out.println("Retriving specific data");
		System.out.println("Enter emp id");
		int empId = Integer.parseInt(sc.nextLine());
		Connection con = getConnection();
		String message = "There is no record!";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("select * from developers where emp_id='"+empId +"'");
			while(rs.next())
			{
				message = "Records retrived successfully!";
				int count = rs.getMetaData().getColumnCount();
				for(int i=1;i<=count;i++)
				{
					System.out.println(rs.getObject(i)+" ");
				}
				System.out.println();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(message);
	}
	
	
	public void updateData()
	{
		System.out.println("Updating data.");
		System.out.println("enter emp id where want to update");
		int empId = Integer.parseInt(sc.nextLine());
		System.out.println("enter emp name what you want to put in place of "+empId);
		String empName = sc.nextLine();
		Connection con = getConnection();
		String message = "Record not found!";
		try
		{
			Statement st = con.createStatement();
			int rows =  st.executeUpdate("update developers set emp_name='"+empName+"' where emp_id='"+empId+"'");
			
			if(rows==1)
			{
				message = "Record update successfully!";
			}
			System.out.println("Do you want to view the data (yes/no)");
			if(sc.nextLine().equalsIgnoreCase("yes"))
			{
				retriveData();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(message);
	}
	
	public static void main(String[] args) 
	{
		 Program1 prog1 =  new Program1();
		 //prog1.retriveData();
		 //prog1.insertDataIntoTable();
		 //prog1.retriveSomeData();
		 prog1.updateData();
	}
}
