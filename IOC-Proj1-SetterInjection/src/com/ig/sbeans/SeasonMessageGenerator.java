package com.ig.sbeans;

import java.time.LocalDateTime;
import java.time.Month;

public class SeasonMessageGenerator 
{
	public LocalDateTime ldt;
	public String name;
	// this is setter method invoked by IOC Container.
	// used to set local date time.
	public void setLdt(LocalDateTime ldt) 
	{
			this.ldt = ldt;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	
	public void defaultInit()
	{
		System.out.println("init default Method invoked");
	}
	
	public void defaultDestroy()
	{
		System.out.println("destroy default Method invoked");
	}
	public void init()
	{
		System.out.println("init Method invoked");
	}
	
	public void destroy()
	{
		System.out.println("destroy Method invoked");
	}
	
	public String getSeasonMessage()
	{
		Month month = ldt.getMonth();
		if(		month==Month.JANUARY ||
				month==Month.FEBRUARY ||
				month==Month.MARCH || 
				month==Month.APRIL
				)
		{
			return "Hi "+name+" Welcome in the month of:-"+month.toString()+"(Winter)";
		}
		else if(month==Month.MAY ||
				month==Month.JUNE ||
				month==Month.JULY || 
				month==Month.AUGUST
				)
		{
			return "Hi "+name+" Welcome in the month of:-"+month.toString()+"(SUMMER)";
		}
		
		return "Hi "+name+" Welcome in the month of:-"+month.toString()+"(RAINY)";
	}
}
