package com.ig.sbeans;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dbm")
public class DBManager 
{
	@Autowired
	private DatabaseProperties prop;
	
	@Autowired
	private Connection con;
	
	private Scanner sc = new Scanner(System.in);
	
	private String getString(String msg)
	{	
		System.out.println(msg);
		String data = sc.nextLine();
		return data;
	}
	
	private int getInt(String msg)
	{	
		System.out.println(msg);
		int data = Integer.parseInt(sc.nextLine());
		return data;
	}
	
	private String getColumns()
	{
		String columns="";
		for(int i=1;i<=prop.getTypes().size();i++)
		{
			String type = prop.getTypes().get(i-1);
			columns+=getString("Enter column name("+type+")");
			columns+= " "+type+
					(
							i==prop.getTypes().size() ?"":","
					);
			
		}
		return columns;
	}
	
	private String getValues()
	{
		String values="";
		for(int i=0;i<prop.getTypes().size();i++)
		{
			String type = prop.getTypes().get(i);
			if(type.equalsIgnoreCase("Timestamp"))
			{
				values+="'"+new Timestamp(System.currentTimeMillis())+"'";
			}
			else if(type.equalsIgnoreCase("int"))
			{
				values+=getString("Enter column value("+type+")");
			}
			else
			{
				values+="'"+getString("Enter column value("+type+")")+"'";
			}
			values+=
			(
					i==prop.getTypes().size()-1 ?"":","
			);
		}
		return values;
	}
	
	public void CreateTable()
	{
		String query = "create table ";
		String tableName = getString("Enter table name:-");
		query+= tableName;
		query+="(";
		query+=getColumns();
		query+=");";
		String msgPass = "table "+tableName+" created successfully!";
		String msgFailed = "table "+tableName+" created failed!";
		try
		{
			Statement st =  con.createStatement();
			System.out.println(query);
			int rows =  st.executeUpdate(query);
			if(rows==0)
			{
				System.out.println(msgPass);
			}
			else
			{
				System.out.println(msgFailed);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void InsertIntoTable()
	{
		String query = "insert into ";
		String tableName = getString("Enter table name:-");
		query+=tableName;
		query+=" values(";
		query+= getValues();
		query+=")";
		String msgPass = "table "+tableName+" inserted successfully!";
		String msgFailed = "table "+tableName+" inserted failed!";
		try
		{
			Statement st =  con.createStatement();
			System.out.println(query);
			int rows =  st.executeUpdate(query);
			if(rows>0)
			{
				System.out.println(msgPass);
			}
			else
			{
				System.out.println(msgFailed);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void RetrieveFromTable()
	{
		String query = "select * from ";
		String tableName = getString("Enter table name:-");
		query+=tableName;
		String msgPass = "data from "+tableName+" retrieve successfully!";
		String msgFailed = "data from "+tableName+" retrieve failed!";
		try
		{
			Statement st =  con.createStatement();
			System.out.println(query);
			ResultSet rs =  st.executeQuery(query);
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
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void OnUpdate()
	{
		String query = "update ";
		String tableName = getString("Enter table name:-");
		String columnName = getString("Enter column name:-");
		String columnNewValue = "'"+getString("Enter new value:-")+"'";
		String whereColumnName = getString("where column name:-");
		String whereColumnValue = "'"+ getString("where new value:-")+"'";
		query+=tableName+" set "+columnName+"="+columnNewValue+" where "+whereColumnName+"="+whereColumnValue;
		String msgPass = "data in "+tableName+" updated successfully!";
		String msgFailed = "data in "+tableName+" updation failed!";
		try
		{
			Statement st =  con.createStatement();
			System.out.println(query);
			int rows =  st.executeUpdate(query);
			if(rows>0)
			{
				System.out.println(msgPass);
			}
			else
			{
				System.out.println(msgFailed);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
