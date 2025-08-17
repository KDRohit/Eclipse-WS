package com.ig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ig.cfgs.AppConfig;
import com.ig.db.DBManager;

public class JDBCMain 
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		DBManager dbManager = ctx.getBean("dbManager",DBManager.class);
		int opt = dbManager.getDBOption();
		if(opt==1)
		{
			dbManager.CreateTable();
		}
		else if(opt==2)
		{
			dbManager.insertIntoTable();
		}
		else if(opt==3)
		{
			dbManager.getDataFromTable();
		}
		else
		{
			dbManager.deleteTable();
		}
		
	}
	
}
