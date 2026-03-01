package com.ig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisTestRunner implements CommandLineRunner {

	@Autowired
	StringCache sc;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(sc.getFullName());
		Thread.sleep(5000);
		System.out.println(sc.updateFullName());
		Thread.sleep(5000);
		System.out.println(sc.getFullName());
		Thread.sleep(5000);
		sc.removeFullName();
		Thread.sleep(5000);
		System.out.println(sc.getFullName());
		
	}
	
	
}
