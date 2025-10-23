package com.ig.controllers;

import java.util.Scanner;

public interface AppController
{
	Scanner sc = new Scanner(System.in);
	void showMenu(boolean isFirst);
	void getAndProcessInput();
	
	default <T> T getInput(String msg,T t)
	{
		System.out.println(msg);
		if(t instanceof String)
		{
			return (T)sc.nextLine();
		}
		
		if(t instanceof Integer)
		{
			Integer inp = Integer.parseInt(sc.nextLine());
			 return (T)inp;		 
		}
		return null;
	}
	
}
