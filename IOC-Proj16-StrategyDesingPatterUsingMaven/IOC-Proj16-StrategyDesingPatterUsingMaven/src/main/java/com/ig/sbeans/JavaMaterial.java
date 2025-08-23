package com.ig.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("java")
@Lazy(true)
public class JavaMaterial implements IMaterial {
	
	private JavaMaterial()
	{
		System.out.println("Java Material is created");
	}
	
	@Override
	public String getMaterial()
	{
		return "Material::Java";
	}

}
