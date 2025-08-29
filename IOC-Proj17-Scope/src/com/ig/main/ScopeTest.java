package com.ig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ig.cfgs.AppConfig;
import com.ig.sbeans.MessageGenerator;
import com.ig.sbeans.ScopeBean;

public class ScopeTest 
{
	public static void main(String[] args) 
	{
		try(AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class))
		//try(ClassPathXmlApplicationContext acac = new ClassPathXmlApplicationContext("com/ig/cfgs/AppConfiguration.xml"))
		{
			//ScopeBean instance1 =   acac.getBean("scopeBean",ScopeBean.class);
			//ScopeBean instance2 =   acac.getBean("scopeBean",ScopeBean.class);
			//System.out.println("------------------------------");
			//System.out.println(instance1.hashCode()+"   "+instance2.hashCode());
			
			System.out.println("Execution completed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
