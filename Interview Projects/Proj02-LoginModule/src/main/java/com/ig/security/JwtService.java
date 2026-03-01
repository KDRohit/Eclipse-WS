package com.ig.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtService 
{
	private final String SECRET = "my-super-secret-key-for-jwt-2026-abcdef";
	
	public String generateToken(String username)
	{
		return Jwts.builder()
				.signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 16))
                .compact();		
	}
	
	public Map<String,Object> validate(String token)
	{
		boolean isValid=false;
		String message = "";
		
	    try {
	       Jws<Claims> jws =   Jwts.parserBuilder()
	                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
	                .build()
	                .parseClaimsJws(token);  // validates signature + expiry
	       String name =  jws.getBody().getSubject();
	        isValid= true;
	        message = "token [ "+name+"] is valid for [ "+jws.getBody().getExpiration()+"]";
	    } 
	    catch(SignatureException e)
	    {
	    	 message = "Token is not matched";
	    }
	    catch (ExpiredJwtException e) 
	    {
	    	message = "Token expired";
	    } 
	    catch (UnsupportedJwtException e)
	    {
	    	message = "Unsupported token";
	    } 
	    catch (MalformedJwtException e) 
	    {
	    	message = "Invalid token";
	    } 
	   catch (IllegalArgumentException e) 
	    {
		   message = "Token is empty";
	    }
	    catch(Exception e)
	    {
	    	message = "Token has some kind of failure";
	    }
	    return Map.of(
	    		"isValid",isValid,
	    		"message",message
	    		);
	}
}
