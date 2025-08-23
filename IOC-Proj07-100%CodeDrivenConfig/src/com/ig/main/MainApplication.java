package com.ig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ig.config.AppConfig;
import com.ig.sbeans.WishMessageGenerator;

public class MainApplication 
{
	public static void main(String[] args) 
	{
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);)
		{
			WishMessageGenerator wmg =  ctx.getBean("wmg",WishMessageGenerator.class);
			
			System.out.println("----------Test welCome message(both target and dependent(injected class) object)");
			System.out.println("----------Both Target and Dependent(injected class) object created using 100% code driven config--------");
			System.out.println(wmg.getMessage("Rohit kumar dubey"));
			
			System.out.println("------------------------");
			System.out.println(wmg.getTestSCMessage());
		}
		catch (Exception e) 
		{
			
		}
	}

}
