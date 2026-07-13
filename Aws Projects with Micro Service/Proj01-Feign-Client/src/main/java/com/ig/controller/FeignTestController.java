package com.ig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.feign.ISecurityTestService;

@RestController
@RequestMapping("/Feign-Client")
public class FeignTestController 
{
	@Autowired
	private ISecurityTestService securityTestService;
	
	@GetMapping("/security-test-service")
	public String find()
	{
		return securityTestService.test();
	}
}
