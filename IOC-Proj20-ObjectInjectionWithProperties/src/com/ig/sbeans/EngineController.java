package com.ig.sbeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ec")
public class EngineController 
{
	//@Value("${engine}")
	@Autowired
	@Qualifier("alias-engine-id")
	private IEngine engine;
	
	public void showEngine()
	{
		System.out.println("Engine Details:-");
		engine.getEngineDetail();
	}
	
}
