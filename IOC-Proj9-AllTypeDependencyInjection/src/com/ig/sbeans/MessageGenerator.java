package com.ig.sbeans;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mg")
public class MessageGenerator 
{
	/*private Scanner sc;*/
	
	/*@Autowired
	@Qualifier("currentThreadName2")*/
	private String currentThreadName;
	
	@Autowired
	private void setCurrentThreadName(@Qualifier("currentThreadName2")String currentThreadName)
	{
		this.currentThreadName=currentThreadName;
	}
	
	public MessageGenerator() 
	{
		System.out.println("MessageGenerator.MessageGenerator() with 0 param constructor invoked");
	}
	/*@Autowired
	private void setScanner(Scanner sc)
	{
		System.out.println("MessageGenerator.setScanner() invoked");
		this.sc=sc;
	}*/
	
	public void getMessage()
	{
		System.out.println("Enter your name:-");
		String name =  ""+currentThreadName;//sc.nextLine();
		System.out.println("Welcome "+name+" in the Message App!");
	}
}
