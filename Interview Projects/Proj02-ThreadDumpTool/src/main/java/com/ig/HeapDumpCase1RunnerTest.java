package com.ig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HeapDumpCase1RunnerTest implements CommandLineRunner 
{
	

	
	@Override
	public void run(String... args) throws Exception 
	{		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 1);
		map.put("C", 1);
		map.put("D", 1);
		map.put("E", 1);
		map.put("F", 1);
		
		map.forEach((key,value)->{
			System.out.println("Key:: "+key);
			System.out.println("Value:: "+value);
		});
		
		
	
		
		
		
	}

}
