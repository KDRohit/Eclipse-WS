package com.ig.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.time.LocalDateTime;

public class ClassPathXmlApplication 
{
	public void showData(String msg,ApplicationContext ctx)
	{
		System.out.println(msg);
		System.out.println("----------------------");
		LocalDateTime ldt= (LocalDateTime)ctx.getBean("ldt");
		System.out.println("current year:-"+ldt.getYear());
		System.out.println("current month:-"+ldt.getMonth());
		System.out.println("current date:-"+ldt.getDayOfYear());
	}
	
	public static void main(String[] args) 
	{
		ClassPathXmlApplication app = new ClassPathXmlApplication();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FileSystemXmlApplicationContext fctx = new FileSystemXmlApplicationContext("C:/Users/rdubey/Saved Games/ApplicationContext.xml");
		app.showData("showing data using ClassPathXmlApplication\n",ctx);
		app.showData("\nshowing data using FileSystemXmlApplicationContext\n",fctx);
	}
}
