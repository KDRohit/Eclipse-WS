package com.ig.main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ig.cfgs.AppConfig;
import com.ig.sbeans.Student;

public class StrategyDesignTest 
{
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//Student stu =  ctx.getBean("student",Student.class);
		//stu.showMaterial();
	}
}
