package com.ig.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ig.sbeans.Employee;
import com.ig.service.DAOService;

@Controller("daoController")
public class DAOController
{
	@Autowired
	private  DAOService dbService;
	
	public void showDBInfo()
	{
		System.out.println(dbService);
	}
	
	private int showMenuGetInput(boolean isFirst,Scanner sc)
	{
		if(isFirst)
			System.out.println("Welcome in the Mini-Project-RAPp !!!!!!");
		
		System.out.println("------------DB Services:--------");
		System.out.println("1)-Selection");
		System.out.println("2)-Insertion");
		System.out.println("3)-Updation");
		System.out.println("4)-Deletion");
		System.out.println("5-Exit");
		System.out.println("------------------------");
		System.out.println("choose any one of above...........");
		int ch =Integer.parseInt(sc.nextLine()) ;
		return ch;
	}
	
	private void setEmployeeByUser(Employee e,Scanner sc)
	{
		
		System.out.println("Enter emp id:-");
		e.setEid(sc.nextLine());
		System.out.println("Enter emp first name:-");
		e.setEfn(sc.nextLine());
		System.out.println("Enter emp last name:-");
		e.setEln(sc.nextLine());
		System.out.println("Enter emp Salary:-");
		e.setSal(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter emp address:-");
		e.setAdd(sc.nextLine());
	}
	
	public void showDBServices(boolean isFirst)
	{
		Scanner sc = new Scanner(System.in);
		int ch = showMenuGetInput(isFirst, sc);
		System.out.println("Enter table name");
		String tableName = sc.nextLine();
		Employee t = new Employee();
		try
		{
			switch (ch) 
			{
				case 1:
				select(tableName, t);
				break;
				
				case 2:
				setEmployeeByUser(t, sc);
				 insert(tableName,t);
				break;
				
				case 3:
				setEmployeeByUser(t, sc);
				update(tableName, t);
				break;
				
				case 5:
				System.out.println("Illegal input ..............\n Bye see you again !!!");
				System.exit(1);
				break;
				
				default:
				System.out.println("Illegal input ..............\n Bye see you again !!!");
				System.exit(1);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public <T> void select(String tableName,T t) throws SQLException
	{
		ArrayList<T> list =  dbService.select(tableName, t);
		System.out.println("\n -----Fetched Data-------");
		list.forEach(t1->System.out.println(t1));
		System.out.println();
		showDBServices(false);
	}
	
	public <T> void  insert(String tableName,T t) throws SQLException
	{
		int result = dbService.insert(tableName, t);
		System.out.println(result==1?"data inserted successfully":"data insertion failed!");
		System.out.println();
		showDBServices(false);
	}
	
	public <T> void  update(String tableName,T t) throws SQLException
	{
		int result = dbService.update(tableName, t);
		System.out.println(result==1?"data updated successfully":"data updation failed!");
		System.out.println();
		showDBServices(false);
	}
}
