package com.ig.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-service")
public class APIController 
{
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name)
	{
		return "Welcome ["+name+"] in the hello app";
	}
}
