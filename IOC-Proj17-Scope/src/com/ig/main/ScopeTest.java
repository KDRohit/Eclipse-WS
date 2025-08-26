package com.ig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ig.cfgs.AppConfig;
import com.ig.sbeans.MessageGenerator;

public class ScopeTest 
{
	public static void main(String[] args) 
	{
		//try(AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class))
		try(ClassPathXmlApplicationContext acac = new ClassPathXmlApplicationContext("com/ig/cfgs/AppConfiguration.xml"))
		{
			MessageGenerator mg1 =   acac.getBean("mg1",MessageGenerator.class);
			MessageGenerator mg2 =   acac.getBean("mg2",MessageGenerator.class);
			System.out.println("Execution completed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
