package com.ig.sbeans;
import java.io.InputStream;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mg")
public class MessageGenerator 
{
	@Autowired
	private Scanner sc;
	@Autowired
	private InputStream in;
	
	public void getMessage()
	{
		System.out.println("Enter your name:-");
		String name =  sc.nextLine();
		System.out.println("Welcome "+name+" in the Message App!");
	}
}
