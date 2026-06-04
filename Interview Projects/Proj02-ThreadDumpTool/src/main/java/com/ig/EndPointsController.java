package com.ig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class EndPointsController 
{
	@GetMapping("/test")
	public String test()
	{
		 synchronized(DeadLockThreadDumpRunnerTest.lock1) {
		        synchronized(DeadLockThreadDumpRunnerTest.lock2) {
		            return "ok";
		        }
		    }
	}
}
