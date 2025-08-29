package com.ig.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Program3 
{
	public String driver = "mysql.jdbc.DriverManager";
	public String dbUrl = "jdbc:mysql://localhost/ingenuity";
	public String user = "root";
	public String pass = "1234";
	
	public Scanner sc = new Scanner(System.in);
	
	public Connection getConnection()
	{
		Connection con = null;
		try
		{
			//Class.forName(driver);
			con =  DriverManager.getConnection(dbUrl,user,pass);
			System.out.println("Connection created successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public void patientOperations()
	{
		Connection con = getConnection();
		try
		{
			PreparedStatement pst = con.prepareStatement("insert into patient values(?,?,?,?)");
			while(true)
			{
				System.out.println("Welcome to the Patient Database");
				System.out.println("-------------------------------");
				System.out.println("1)-Add Patient");
				System.out.println("2)-Views Patients");
				System.out.println("3)-Retrieve Patients Data");
				System.out.println("4)-Update Patients Data");
				System.out.println("5)-Delete Patients Data");
				System.out.println("6)-Exit");
				System.out.println("Enter your choice[1-6]");
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice)
				{
					case 1:
						System.out.println("Inserting patient Data\n");
						
						System.out.println("Enter patient Id:-");
						String p_id = sc.nextLine();
						
						System.out.println("Enter patient Name:-");
						String p_name = sc.nextLine();
						
						System.out.println("Enter patient Age:-");
						int p_age = Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter patient Contact no:-");
						long p_contact = Long.parseLong(sc.nextLine());
						
						pst.setString(1, p_id);
						pst.setString(2, p_name);
						pst.setInt(3, p_age);
						pst.setLong(4, p_contact);
						
						int rows =  pst.executeUpdate();
						if(rows>0)
						{
							System.out.println("Record Inserted Successfully!");
						}
						else
						{
							System.out.println("Patient Record Not Inserted!");
						}
						
					break;
					
					case 2:
						
					break;
					
					case 3:
					break;
						
					case 4:
					break;
					
					case 5:
					break;
					
					case 6:
						System.out.println("Thankyou see you soon!");
						System.exit(0);
					break;
					
					default:
						System.out.println("\n<<<<<<<<Please choose valid options>>>>>>>\n");
				}
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		new Program3().patientOperations();
	}
	
}
