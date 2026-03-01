package com.ig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController 
{
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	
	@GetMapping("/only_authenticated")
	public String onlyAuthenticated()
	{
		return "only_authenticated";
	}
	
	@GetMapping("/only_authorized")
	public String onlyAuthorized()
	{
		return "only_authorized";
	}
	
	@GetMapping("/no_authenticated_and_no_authorized")
	public String noAuthenticatedNoAuthorized()
	{
		return "no_authenticated_no_authorized";
	}
	
	@GetMapping("/denied")
	public String denied()
	{
		return "denied";
	}
}
