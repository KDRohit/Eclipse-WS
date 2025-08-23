package com.ig.sbeans;

public class ClassA
{
	public ClassB b;

	public void setB(ClassB b) 
	{
		System.out.println("ClassA.setB()");
		this.b = b;
		
	}
}
