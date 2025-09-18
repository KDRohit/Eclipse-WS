package com.ig;

public class DebugTest 
{
	void meth1()
	{
		System.out.println("DebugTest.meth1()");
		meth2("rohit");
	}
	
	void meth2(String str)
	{
		System.out.println("DebugTest.meth2()");
		System.out.println(str);
		meth3(10);
	}
	
	void meth3(int i)
	{
		for(int s =0;s<=i;s++)
		{
			System.out.println("testing "+s);
		}
	}
	
	public static void main(String[] args) 
	{
		DebugTest test = new DebugTest();
		test.meth1();
	}
}
