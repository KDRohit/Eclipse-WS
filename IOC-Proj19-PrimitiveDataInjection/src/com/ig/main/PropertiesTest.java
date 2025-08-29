package com.ig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ig.cfgs.AppConfig;
import com.ig.sbeans.DBManager;
import com.ig.sbeans.DBUIManager;
import com.ig.sbeans.DatabaseProperties;

public class PropertiesTest 
{
	public static void main(String[] args) 
	{
		PropertiesTest test = new PropertiesTest();
		try(AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class))
		{
			DBUIManager dbuiManager =  acac.getBean("dbui",DBUIManager.class);
			dbuiManager.showMenu();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
