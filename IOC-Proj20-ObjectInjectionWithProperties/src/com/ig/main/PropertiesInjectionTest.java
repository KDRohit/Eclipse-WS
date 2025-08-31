package com.ig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ig.cfgs.AppConfig;
import com.ig.sbeans.Employee;

public class PropertiesInjectionTest 
{
	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class))
		{
			Employee e1 = acac.getBean("emp",Employee.class);
			System.out.println(e1);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
