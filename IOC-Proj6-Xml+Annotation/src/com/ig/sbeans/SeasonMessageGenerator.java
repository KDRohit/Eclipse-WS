package com.ig.sbeans;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("smg")
public class SeasonMessageGenerator 
{
	@Autowired
	private LocalDateTime ldt;
	
	private String name = "no-name";
	
	public String getName() 
	{
		 return name;
	}

	public String getMessage()
	{
		return ""+ldt.getYear();
	}
}
