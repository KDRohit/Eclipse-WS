package com.ig.sbeans;

import java.util.Scanner;

public class ClassA 
{
	public String message;
	public Scanner sc;

	public ClassA(Scanner sc) 
	{
		this.sc = sc;
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
