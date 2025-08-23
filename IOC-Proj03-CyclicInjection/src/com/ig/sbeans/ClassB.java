package com.ig.sbeans;

public class ClassB{
	public ClassA a;

	public void setA(ClassA a) 
	{
		System.out.println("ClassB.setA()");
		this.a = a;
	}
}
