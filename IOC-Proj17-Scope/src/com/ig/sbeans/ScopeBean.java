package com.ig.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("scopeBean")
@Scope("singleton")
//@Lazy(true)
public class ScopeBean 
{
	public ScopeBean()
	{
		System.out.println("Scope bean "+this.hashCode()+" instantiated");
	}
}
