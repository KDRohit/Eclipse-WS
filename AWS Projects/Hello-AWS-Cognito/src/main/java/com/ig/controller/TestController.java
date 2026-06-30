package com.ig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
	@GetMapping("/admin")
	public String helloAdmin()
	{
		return "welcome :: admin";
	}
	
	@GetMapping("/user")
	public String helloUser()
	{
		return "welcome :: user";
	}
	
	@GetMapping("/public")
	public String helloPublic()
	{
		return "welcome :: public";
	}
}
