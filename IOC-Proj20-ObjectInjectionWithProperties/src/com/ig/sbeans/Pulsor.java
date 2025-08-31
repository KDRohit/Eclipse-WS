package com.ig.sbeans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("pulsor")
public class Pulsor implements IEngine {
	@Value("${engine.pulsor.prize}")
	private Integer prize;
	
	@Override
	public void getEngineDetail() 
	{
		System.out.println("Engine:pulsor");
		System.out.println("Prize:"+prize);
	}

}
