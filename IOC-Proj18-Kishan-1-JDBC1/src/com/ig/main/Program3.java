package com.ig.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public void addPatient()
	{
		try
		{
			Connection con = getConnection();
			
			PreparedStatement pst1 = con.prepareStatement("insert into patient values(?,?,?,?)");
			
			System.out.println("Inserting patient Data\n");
			
			System.out.println("Enter patient Id:-");
			String p_id = sc.nextLine();
			
			System.out.println("Enter patient Name:-");
			String p_name = sc.nextLine();
			
			System.out.println("Enter patient Age:-");
			int p_age = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter patient Contact no:-");
			long p_contact = Long.parseLong(sc.nextLine());
			
			pst1.setString(1, p_id);
			pst1.setString(2, p_name);
			pst1.setInt(3, p_age);
			pst1.setLong(4, p_contact);
			
			int rows =  pst1.executeUpdate();
			if(rows>0)
			{
				System.out.println("Record Inserted Successfully!");
			}
			else
			{
				System.out.println("Patient Record Not Inserted!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void retrievePatientsData()
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from patient where pid=?");
			System.out.println("Retrieving data from table");
			System.out.println("Please Enter patient Id:-");
			String pid = sc.nextLine();
			pst.setString(1, pid);
			ResultSet rs =  pst.executeQuery();
			if(rs.next())
			{
				int cols = rs.getMetaData().getColumnCount();
				for(int i=1;i<=cols;i++)
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
		
	}
	
	public void updatePatients()
	{
		try 
		{
			System.out.println("updating patient data");
			System.out.println("Please Enter patient Id:-");
			String pid = sc.nextLine();
			System.out.println("Please Enter patient age:-");
			int page = Integer.parseInt(sc.nextLine());
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update patient set age = ? where pid = ?");
			pst.setInt(1, page);
			pst.setString(2, pid);
			int rows =  pst.executeUpdate();
			if(rows>0)
			{
				System.out.println("Patient "+pid+" updated successfully!");
			}
			else
			{
				System.out.println("Patient "+pid+" failed to update!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void viewPatients()
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from patient",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs =  pst.executeQuery();
			while(rs.next())
			{
				int cols = rs.getMetaData().getColumnCount();
				for(int i=1;i<=cols;i++)
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
	}
	
	public void deletePatients()
	{
		try 
		{
			System.out.println("deleting patient data");
			System.out.println("Please Enter patient Id:-");
			String pid = sc.nextLine();
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from patient where pid = ?");
			pst.setString(1, pid);
			int rows =  pst.executeUpdate();
			if(rows>0)
			{
				System.out.println("Patient "+pid+" deleted successfully!");
			}
			else
			{
				System.out.println("Patient "+pid+" failed to delete!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void patientOperations()
	{
		Connection con = getConnection();
		try
		{
			
			PreparedStatement pst2= con.prepareStatement("insert into patient values(?,?,?,?)");
			
			PreparedStatement pst4 = con.prepareStatement("update patient set age = ? where pid = ?");
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
					addPatient();
					break;
					
					case 2:
					viewPatients();
					break;
					
					case 3:
					retrievePatientsData();	
					break;
						
					case 4:
					updatePatients();
					break;
					
					case 5:
					deletePatients();
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
