package com.ig.main;

import java.util.Arrays;
import java.util.Scanner;

public class MetaDataApp 
{
	public static void main(String[] args) 
	{
		Class sc = Scanner.class;
		System.out.println("class name:-"+sc.getName());
		System.out.println();
		System.out.println();
		System.out.println("super class name:-"+sc.getSuperclass().getName());
		System.out.println();
		System.out.println();
		System.out.println("All declared methods:- "+Arrays.toString(sc.getDeclaredMethods()));
		System.out.println();
		System.out.println();
		System.out.println("All interfaces:-"+Arrays.toString(sc.getInterfaces()));
	}
}
