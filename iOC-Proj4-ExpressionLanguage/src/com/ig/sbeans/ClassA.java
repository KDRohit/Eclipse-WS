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
	
	public String getMessage() 
	{
		return message;
	}
	
}
