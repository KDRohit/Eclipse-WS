package com.ig.main;

import com.ig.sbeans.Customer;

public class LambokAPITest
{
	public static void main(String[] args) 
	{
		Customer c1 = new Customer(1,"Rohit",1200);
		Customer c2 = new Customer(1,"Rohit",1200);
		/*c.setName("Rohit");
		c.setId(1);
		c.setBillAmount(1200);*/
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(System.identityHashCode(c1));
		System.out.println(System.identityHashCode(c2));
		System.out.println("c1==c2 "+(c1==c2));
		System.out.println("c1.equals(c2)="+c1.equals(c2));
		
		
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = o1;
		
		
		System.out.println(o1.equals(o2)+" and "+(o1==o2));
		System.out.println(o1.equals(o3)+" and "+(o1==o3));
		// s1 is storing the reference means address of the value stored
		//also here compiler is not going to create any object of String class)
		// compiler will store value and return the address of the value for future refrence.
		String s1 = "java"; 
		
		// here compiler is return the same address of previously stored value and return to s1 the same address will be returned to s2. 
		String s2 = "java"; 
		
		String s3 = new String("java"); // s2 is storing the reference of the object.
		String s4 = new String("java"); // s3 is storing the reference of the object.
		
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		
		
		
		
		
	}
}
