package com.ig.sbeans;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dbui")
public class DBUIManager 
{ 
	@Autowired
	private DBManager dbManager;
	
	public void showMenu()
	{
		System.out.println("Welcome to the database management!");
		System.out.println("-----------------------------------");
		System.out.println("Select Options:-");
		System.out.println("1:- Create Table");
		System.out.println("2:- Insert Into Table");
		System.out.println("3:- Update Table");
		System.out.println("4:- Delete Table");
		System.out.println("5:- Retrive from Table");
		System.out.println("6:- Exit");
		
		Scanner sc = new Scanner(System.in);
		int opt = Integer.parseInt(sc.nextLine());
		switch(opt)
		{
			case 1:
				OnCreateTable();
			break;
				
			case 2:
				OnInsertIntoTable();
			break;
			
			case 3:
				OnUpdateIntoTable();
			break;
			
			case 4:
				OnDeleteFromTable();
			break;
			
			case 5:
				OnSelectFromTable();
			break;
			
			case 6:
				OnExit();
			break;
			
			
		}
	}
	
	public void OnCreateTable()
	{
		dbManager.CreateTable();
		showMenu();
	}
	
	public void OnInsertIntoTable()
	{
		dbManager.InsertIntoTable();
		showMenu();
	}
	public void OnUpdateIntoTable()
	{
		showMenu();
	}
	public void OnDeleteFromTable()
	{
		showMenu();
	}
	public void OnSelectFromTable()
	{
		dbManager.RetrieveFromTable();
		showMenu();
	}
	public void OnExit()
	{
		System.exit(1);
	}
}
