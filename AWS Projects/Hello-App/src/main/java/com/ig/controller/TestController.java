package com.ig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.service.CustomUserDetailsService;

@RestController
@RequestMapping("/test-service")
public class TestController
{
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@GetMapping("/art")
	public String testArt()
	{
		return 
				"hello [ Username :: "+customUserDetailsService.getLoginUser().name
		      +", Password :: "+customUserDetailsService.getLoginUser().password
		      + ", HashCode :: "+customUserDetailsService.getLoginUser().hashCode()
		      +"]";
	}
	
	@GetMapping("/dev")
	public String testDev()
	{
		return 
				"hello [ Username :: "+customUserDetailsService.getLoginUser().name
		      +", Password :: "+customUserDetailsService.getLoginUser().password
		      + ", HashCode :: "+customUserDetailsService.getLoginUser().hashCode()
		      +"]";
	}
	
	@GetMapping("/qa")
	public String testQA()
	{
		return 
				"hello [ Username :: "+customUserDetailsService.getLoginUser().name
		      +", Password :: "+customUserDetailsService.getLoginUser().password
		      + ", HashCode :: "+customUserDetailsService.getLoginUser().hashCode()
		      +"]";
	}
}
