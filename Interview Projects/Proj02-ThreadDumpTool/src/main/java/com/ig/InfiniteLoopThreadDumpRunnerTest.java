package com.ig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class InfiniteLoopThreadDumpRunnerTest implements CommandLineRunner 
{
	@Override
	public void run(String... args) throws Exception 
	{
		for(int i=0;;i++)
		{
			
		}
	}
}
