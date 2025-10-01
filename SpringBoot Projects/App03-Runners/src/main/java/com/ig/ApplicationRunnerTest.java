package com.ig;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("art")
@Order(3)
@Profile("tester")
public class ApplicationRunnerTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		System.out.println("Executed :: ApplicationRunnerTest.run(args)");
		List<String>  noargs = args.getNonOptionArgs();
		System.out.println("NonOptionArgs :: "+ Arrays.toString( noargs.toArray() ) );
		
		for(String key : args.getOptionNames())
		{
			System.out.println("key:"+key);
			System.out.println("value:"+args.getOptionValues(key));
		}
		System.out.println("\n\n");
	}

}
