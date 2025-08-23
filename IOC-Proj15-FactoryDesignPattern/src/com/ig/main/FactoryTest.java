package com.ig.main;

import com.ig.beans.IMaterial;
import com.ig.factory.FactoryMaterial;

public class FactoryTest 
{
	// here we don't know which object is going to assign ===> "Runtime Assignment"  ===> "Runtime Polymorphism".
	public static IMaterial material;
	
	public static void main(String[] args) 
	{
		material =  FactoryMaterial.getMaterial("java");
		System.out.println(material.getMaterial());
		
		material =  FactoryMaterial.getMaterial("oracle");
		System.out.println(material.getMaterial());
	}
}
