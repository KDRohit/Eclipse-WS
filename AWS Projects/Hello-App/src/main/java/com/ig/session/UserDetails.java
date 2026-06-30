package com.ig.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(scopeName = "session")
@Component
public class UserDetails 
{
	public String name;
	public String password;
}
