package com.ig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController 
{
	@GetMapping("/test")
	public String test()
	{
		return "test is completed";
	}
}
