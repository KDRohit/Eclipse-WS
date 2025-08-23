package com.ig.sbeans;

public class UserDefineClassFactory 
{
	public static ClassA getInstanceA()
	{
		return new ClassA();
	}
	public ClassB getInstanceB()
	{
		return new ClassB();
	}
}
