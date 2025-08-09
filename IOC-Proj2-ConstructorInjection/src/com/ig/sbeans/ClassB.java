package com.ig.sbeans;

public class ClassB implements NotificationService
{
	public void defaultInit()
	{
		System.out.println("class B Instantiated");
	}
	@Override
	public String message() 
	{
		return "Message from class B";
		
	}
}
