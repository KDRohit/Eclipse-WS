package com.ig.sbeans;

public class ClassB implements NotificationService
{
	public void defaultInit()
	{
		System.out.println("class B Instantiated");
	}
	@Override
	public void message() 
	{
		System.out.println("Message from class B");
		
	}
}
