package com.ig.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.config.CognitoSecretHashGenerator;
import com.ig.response.TokenResponse;
import com.ig.service.CognitoAuthService;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthenticationResultType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderResponse;

@RestController
@RequestMapping("/security")
@Slf4j
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
	
	
	@GetMapping("/create/{username}/{tempPassword}/{permamentPassword}/{groupName}")
	public Map<String, String> createUser
	(
			@PathVariable String username, 
			@PathVariable String tempPassword,
			@PathVariable String permamentPassword,
			@PathVariable String groupName
			)
	{
		Map<String,String> response = new HashMap<>();
		Map<String,CognitoIdentityProviderResponse>createUserResult = cognitoAuthService.createUser(username, tempPassword, permamentPassword, groupName);
		response.put("user_created",createUserResult.get("admin_create_user_response").toString());
		response.put("add_user_to_group",createUserResult.get("admin_add_user_to_group_response").toString());
		response.put("set_user_password",createUserResult.get("admin_set_user_password_response").toString());
		return response;
	}
	
}
