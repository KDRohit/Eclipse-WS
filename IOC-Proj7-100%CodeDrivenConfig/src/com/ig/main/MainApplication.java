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
			String wishMessage =  wmg.getMessage("Rohit kumar dubey");
			System.out.println(wishMessage);
		}
		catch (Exception e) 
		{
			
		}
	}

}
