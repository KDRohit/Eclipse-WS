package com.ig.sbeans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("honda")
public class Honda implements IEngine {
	@Value("${engine.honda.prize}")
	private Integer prize;
	
	@Override
	public void getEngineDetail() 
	{
		System.out.println("Engine:honda");
		System.out.println("Prize:"+prize);
	}

}
