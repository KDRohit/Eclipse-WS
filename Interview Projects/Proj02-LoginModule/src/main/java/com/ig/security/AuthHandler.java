package com.ig.security;

import java.util.Map;
import org.springframework.stereotype.Component;

import com.ig.response.LoginSuccess;
import com.ig.response.Response;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class AuthHandler 
{
//		@Autowired
//	 	private AuthenticationManager authenticationManager;
		@Autowired
	    private JwtService jwtService;
		
		public LoginSuccess getAuthentication(String username, String password)
		{
//			Authentication authentication = authenticationManager.authenticate(
//	                new UsernamePasswordAuthenticationToken(
//	                		username,
//	                		password
//	                )
//	        );
	        String token = jwtService.generateToken(username);
	        String expiresIn = ""+(System.currentTimeMillis() + 1000 * 60 * 60);
	        return new LoginSuccess(username, token, "Bearer", expiresIn);
		}
		
		public Response<Boolean> validate(String token)
		{
	       Map map  = jwtService.validate(token);
	       return new Response<Boolean>("200",(String)map.get("message"),(Boolean)map.get("isValid")) ;
		}
}
