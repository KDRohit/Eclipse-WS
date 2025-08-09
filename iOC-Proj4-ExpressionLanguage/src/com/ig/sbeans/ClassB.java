package com.ig.sbeans;

import java.util.Scanner;

public class ClassB 
{
	public String message;
	public Scanner sc;

	public ClassB(Scanner sc) 
	{
		this.sc = sc;
	}
	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
} 
