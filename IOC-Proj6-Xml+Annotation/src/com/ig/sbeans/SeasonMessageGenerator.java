package com.ig.sbeans;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("smg")
public class SeasonMessageGenerator 
{
	@Autowired
	public LocalDateTime ldt;

	@Autowired
	public void setLdt(LocalDateTime ldt)
	{
		this.ldt = ldt;
	}
	
	public String getMessage()
	{
		return ""+ldt.getYear();
	}
}
