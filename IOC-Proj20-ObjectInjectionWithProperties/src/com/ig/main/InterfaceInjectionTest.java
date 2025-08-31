package com.ig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ig.cfgs.AppConfig;
import com.ig.sbeans.Employee;
import com.ig.sbeans.EngineController;

public class InterfaceInjectionTest 
{
	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class))
		{
			EngineController ec = acac.getBean("ec",EngineController.class);
			ec.showEngine();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
