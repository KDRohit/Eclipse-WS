package com.ig.factory;

import com.ig.beans.IMaterial;
import com.ig.beans.JavaMaterial;
import com.ig.beans.OracleMaterial;

public class FactoryMaterial 
{
	public static IMaterial getMaterial(String material)
	{
		if(material.equalsIgnoreCase("java"))
		{
			return new JavaMaterial();
		}
		else if(material.equalsIgnoreCase("oracle"))
		{
			return new OracleMaterial();
		}
		else
		{
			throw new IllegalArgumentException("Illegal Argument "+material);
		}
	}
}
