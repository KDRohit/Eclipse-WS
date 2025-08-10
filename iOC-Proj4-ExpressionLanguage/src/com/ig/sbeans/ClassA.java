package com.ig.sbeans;
import java.util.Scanner;

public class ClassA 
{
	public static int value=100;
	public String message;
	public Scanner sc;
	public int temp=0;
	

	public ClassA(Scanner sc,int temp) 
	{
		this.sc = sc;
		this.temp=temp;
	}
	
	public void setMessage(String message) 
	{
		this.message = message;
	}
	
	public void defaultInit()
	{
		System.out.println("default init method invoked from beans tag");
	}
	public void defaultDestroy()
	{
		System.out.println("default destroy method invoked from beans tag");
	}
	public String getMessage() 
	{
	    System.out.println("Enter message: set to B's message");
	    return sc.nextLine();
	}
	
}
