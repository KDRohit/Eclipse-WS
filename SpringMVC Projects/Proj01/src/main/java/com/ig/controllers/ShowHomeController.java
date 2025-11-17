package com.ig.controllers;
import java.time.LocalDate;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ShowHomeController 
{
	@GetMapping("/")
	public String getHomePage(Map<String, Object> dataRenderer)
	{
		dataRenderer.put("name", "Rohit dubey");
		dataRenderer.put("DOB", LocalDate.now());
		return "welcome";
	}
	
	@PostMapping("/") 
	public String getWelcomePage(Map<String, Object>dataRenderer)
	{ 
		 dataRenderer.put("name", "Rohit dubey");
		 dataRenderer.put("DOB", LocalDate.now()); 
		 return "welcome";
	}
	 
}
