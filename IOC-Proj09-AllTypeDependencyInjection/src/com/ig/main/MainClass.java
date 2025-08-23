package com.ig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ig.cfgs.AppConfig;
import com.ig.sbeans.MessageGenerator;

public class MainClass 
{
	public static void main(String[] args) throws Exception
	{
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class))
		{
			 MessageGenerator msg = ctx.getBean("mg",MessageGenerator.class);
			 msg.getMessage();
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
