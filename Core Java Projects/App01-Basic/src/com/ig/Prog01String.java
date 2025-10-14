package com.ig;

public class Prog01String
{
	String s;
	StringBuilder sbd;
	StringBuffer sbf;
	
	void testString()
	{
		String s1 = "test";
		String s2 = "test";
		String s3 = new String("test");
		
		System.out.println
		(
				"s1 = "+s1+
				"\n"+"s2 = "+s2+
				"\n"+"s3 = "+s3
		);
		
		System.out.println
		(
				"s1.hashCode() : "+s1.hashCode()+
				"\n"+"s2.hashCode() : "+s2.hashCode()+
				"\n"+"s3.hashCode() : "+s3.hashCode()
		);
		
		System.out.println
		(
				"System.identityHashCode(s1)  : "+System.identityHashCode(s1)+
				"\n"+"System.identityHashCode(s2)  : "+System.identityHashCode(s2)+
				"\n"+"System.identityHashCode(s3)  : "+System.identityHashCode(s3)
		);
		
		System.out.println
		(
				"s1==s2 : "+(s1==s2)+
				"\n"+", s1==s3 : "+(s1==s3)
		);
		System.out.println
		(
				"s1.equals(s2) : "+(s1.equals(s2))+
				"\n"+"s1.equals(s3) : "+(s1.equals(s3))
		);
	}
	
	boolean testPalindrome(String s)
	{
		String sob = new String(s);
		sbd =new StringBuilder(s);
		sbf = new StringBuffer(s);
		
		// reverse string
		sbd.reverse();
		sbf.reverse();
		
		return sbd.toString().equals(sob.toString());
	}
	
	 void testCapacity(String s)
	 {
		 sbd =new StringBuilder(s);
		 sbf = new StringBuffer(s);
		 System.out.println("StringBuilder(Length) : "+sbd.length());
		 System.out.println("StringBuffer(Length) : "+sbf.length());
		 System.out.println("StringBuilder(Capacity) : "+sbd.capacity());
		 System.out.println("StringBuffer(Capacity) : "+sbf.capacity());
	 }
	
	public static void main(String[] args)
	{ 
		Prog01String obj1 =  new Prog01String();
		/*
		 * System.out.println("pallindrom (madam) : "+obj1.testPalindrome("madam"));
		 * System.out.println("pallindrom (ravi) : "+obj1.testPalindrome("ravi"));
		 * System.out.println("pallindrom (level) : "+obj1.testPalindrome("level"));
		 * obj1.testCapacity("");
		 */
		obj1.testString();
	}
}
