package com.ig.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.response.LoginSuccess;
import com.ig.response.Response;
import com.ig.security.AuthHandler;

@RestController
@RequestMapping("/auth")
public class LoginController 
{
	@Autowired
	AuthHandler authHandler;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<Response<LoginSuccess>> login(@PathVariable String username, @PathVariable String password)
	{
		LoginSuccess loginResponse  =  authHandler.getAuthentication(username, password);
		return ResponseEntity.ok(new Response("200","Login successful ",loginResponse));
		//return ResponseEntity.status(HttpStatus.OK).body(new Response("200","Login successful ",loginResponse));
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/validate/{token}")
	public ResponseEntity<Response<Boolean>> validate(@PathVariable String token)
	{
		System.out.println("token :: "+token);
		Response response =  authHandler.validate(token);
		return ResponseEntity.ok(response);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/validate")
	public ResponseEntity<Response<Boolean>> authorize(@RequestHeader(value = "Authorization",required = false) String authorizationHeader)
	{
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	        String token = authorizationHeader.substring(7); // remove "Bearer "
	        System.out.println("Token: " + token);
	        Response response =  authHandler.validate(token);
			return ResponseEntity.ok(response);
	    }
		return ResponseEntity.ok(new Response("200","Aurhorization not found !!!",false));
	}
}
