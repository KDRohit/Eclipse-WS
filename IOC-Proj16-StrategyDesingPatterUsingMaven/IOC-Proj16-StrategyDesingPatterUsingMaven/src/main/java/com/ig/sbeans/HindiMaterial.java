package com.ig.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("hindi")
@Lazy(true)
public class HindiMaterial implements IMaterial {

	private HindiMaterial()
	{
		System.out.println("Hindi Material is created");
	}
	
	@Override
	public String getMaterial() 
	{
		return "Material::Hindi";
	}

}
