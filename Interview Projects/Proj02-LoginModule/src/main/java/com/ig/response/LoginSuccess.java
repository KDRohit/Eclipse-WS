package com.ig.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginSuccess 
{
	public String username;
	public String accessToken;
	public String tokenType;
	public String expiresIn;
}
