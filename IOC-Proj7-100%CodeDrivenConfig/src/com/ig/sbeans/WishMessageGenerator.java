package com.ig.sbeans;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator 
{
	@Autowired
	private LocalDateTime ldt;
	
	@Autowired
	private Scanner sc;
	
	
	public String getMessage(String name)
	{
		int dow =  ldt.getDayOfWeek().getValue();
		if(5>=dow)
		{
			return "welcome "+name+ " have a nice working day!";
		}
		else
		{
			return "welcome "+name+" have a nice holiday!";
		}
	}
	
	public String getTestSCMessage()
	{
		if(sc!=null)
		{
			System.out.println("Enter some text.....");
			String msg = sc.nextLine();
			return msg;
		}
		return "'sc' is not instantiated";
	}
	
}
