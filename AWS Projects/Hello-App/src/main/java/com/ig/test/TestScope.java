package com.ig.test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TestScope 
{
	public void show(String str)
	{
		System.out.println("Test Scope :: "+this);
	}
}
