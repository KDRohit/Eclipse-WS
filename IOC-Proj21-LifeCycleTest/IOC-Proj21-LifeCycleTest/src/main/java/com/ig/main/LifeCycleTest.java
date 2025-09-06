package com.ig.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ig.cfgs.AppConfig;
import com.ig.sbeans.Bean1;

public class LifeCycleTest 
{
	public static void main(String[] args) 
	{
		try(AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);)
		{
			Bean1 b1 =  acac.getBean("b1",Bean1.class);
			System.out.println(b1);
			
			Scanner sc =  acac.getBean("sc",Scanner.class);
			System.out.println(sc);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
