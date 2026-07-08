package com.ig.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.config.CognitoSecretHashGenerator;
import com.ig.response.TokenResponse;
import com.ig.service.CognitoAuthService;

import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthenticationResultType;

@RestController
@RequestMapping("/test")
public class TestController
{
	@Autowired
	CognitoAuthService cognitoAuthService;
	
	@GetMapping("/admin")
	public String helloAdmin()
	{
		return "welcome :: admin";
	}
	
	@GetMapping("/user")
	public String helloUser()
	{
		return "welcome :: user";
	}
	
	@GetMapping("/public")
	public String helloPublic()
	{
		return "welcome :: public";
	}
	
	@GetMapping("/secrethash/{username}")
	public String getSecretHash
	(
			@PathVariable String username
	)
	{
		String secretHash = CognitoSecretHashGenerator.generateSecretHash(username, CognitoAuthService.clientId, CognitoAuthService.clientSecret);
		return secretHash;
	}
	
	@GetMapping("/token/{username}/{password}")
	public TokenResponse getToken
	(
			@PathVariable String username, 
			@PathVariable String password
			)
	{
		String secretHash = CognitoSecretHashGenerator.generateSecretHash(username, CognitoAuthService.clientId, CognitoAuthService.clientSecret);
		AuthenticationResultType result =  cognitoAuthService.login(username, password, CognitoAuthService.clientId, secretHash);
		TokenResponse response = new TokenResponse();
		BeanUtils.copyProperties(result, response);
		return response;
	}
	
	@GetMapping("/create/{username}/{tempPassword}/{permamentPassword}")
	public void createUser
	(
			@PathVariable String username, 
			@PathVariable String tempPassword,
			@PathVariable String permamentPassword
			)
	{
		
	}
	
}
