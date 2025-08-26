package com.ig.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("mg")
//@Scope("prototype")
//@Lazy(true)

@Component("mg")
@Scope("prototype")
public class MessageGenerator 
{
	private static MessageGenerator instance;
	
	private MessageGenerator()
	{
		System.out.println("instance "+this.hashCode()+" Created.");
	}
	
	public static MessageGenerator getInstance()
	{
		if(instance==null)
		{
			instance = new MessageGenerator();
		}
		return instance;
	}
	
	public void generateMessage(String message)
	{
		System.out.println(message);
	}
}
