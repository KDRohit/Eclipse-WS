package com.ig.sbeans;

public class ClassA implements NotificationService
{
	public void defaultInit()
	{
		System.out.println("class A Instantiated");
	}

	@Override
	public void message() 
	{
		System.out.println("Message from class A");
		
	}
	 
}
