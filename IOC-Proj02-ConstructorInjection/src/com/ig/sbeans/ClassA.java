package com.ig.sbeans;

public class ClassA implements NotificationService
{
	public void defaultInit()
	{
		System.out.println("class A Instantiated");
	}

	@Override
	public String message() 
	{
		return "Message from class A";
		
	}
	 
}
