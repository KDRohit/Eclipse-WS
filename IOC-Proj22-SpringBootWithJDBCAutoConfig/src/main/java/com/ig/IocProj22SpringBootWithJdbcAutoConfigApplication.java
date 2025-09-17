package com.ig;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ig.controller.DevController;
import com.ig.models.Developer;
import com.ig.service.DeveloperService;

@SpringBootApplication
public class IocProj22SpringBootWithJdbcAutoConfigApplication {
	
	public void getAllDevelopers(DevController devController)
	{
		try
		{
			List<Developer> allDevs = devController.getAllDevelopers();
			if(allDevs==null || allDevs.size()==0)
			{
				System.out.println("No record found!!!");
			}
			else
			{
				allDevs.forEach(dev->System.out.println(dev));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	public void getDevelopersBasedOnId(DevController devController)
	{
		System.out.println("Enter emp id:-");
		try(Scanner sc = new Scanner(System.in);)
		{
			String empId =  sc.nextLine();
			List<Developer> allDevs = devController.getDevelopersBasedOnId(empId);
			
			if(allDevs==null || allDevs.size()==0)
			{
				System.out.println("No record found!!!");
			}
			else
			{
				allDevs.forEach(dev->System.out.println(dev));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void InsertDev(DevController devController)
	{
		try(Scanner sc = new Scanner(System.in);)
		{
			System.out.println("Enter empId :-");
			String empId =  sc.nextLine();
			
			System.out.println("Enter emp name :-");
			String empName = sc.nextLine();
			
			System.out.println("Enter emp action  :-");
			String empAction = sc.nextLine();
			
			Developer dev = new Developer(empId, empName, empAction);
			String str =  devController.InsertDev(dev);
			System.out.println(str);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception
	{	
		IocProj22SpringBootWithJdbcAutoConfigApplication pro = new IocProj22SpringBootWithJdbcAutoConfigApplication();
		
		
		try(
				ConfigurableApplicationContext cac =   SpringApplication.run(IocProj22SpringBootWithJdbcAutoConfigApplication.class, args);
				)
		{
			System.out.println("\n------Execution started---------");
			DevController devController =  cac.getBean("devcontroller", DevController.class);
			//pro.getAllDevelopers(devController);
			//pro.getDevelopersBasedOnId(devController);	
			pro.InsertDev(devController);
			System.out.println("------Execution completed-----");
		}
	}
}
