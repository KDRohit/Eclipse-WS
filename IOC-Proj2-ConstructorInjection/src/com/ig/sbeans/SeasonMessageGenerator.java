package com.ig.sbeans;

import java.time.LocalDateTime;
import java.time.Month;

public class SeasonMessageGenerator 
{
	public NotificationService service;
	
	public SeasonMessageGenerator(NotificationService service) 
	{
		this.service = service;
	}
	
	public String getSeasonMessage()
	{
		return service.message();
		
	}
}
