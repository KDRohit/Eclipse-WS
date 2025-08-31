package com.ig.sbeans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("bajaj")
public class Bajaj implements IEngine {
	@Value("${engine.bajaj.prize}")
	private Integer prize;
	
	@Override
	public void getEngineDetail() 
	{
		System.out.println("Engine:Bajaj");
		System.out.println("Prize:"+prize);
	}

}
