package com.ig.sbeans;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator 
{
	@Autowired
	public LocalDateTime ldt;
	
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
	
}
