package com.ig;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(2)
@Profile({"dev"})
public class CommandRunnerTest implements CommandLineRunner ,Ordered
{
	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("We have not called !!!!");
		System.out.println("Executed:: CommandRunnerTest.run(String... args)");
		System.out.println(Arrays.toString(args));
		System.out.println("\n\n");
	}

	@Override
	public int getOrder() 
	{
		return 4;
	}
	
}
