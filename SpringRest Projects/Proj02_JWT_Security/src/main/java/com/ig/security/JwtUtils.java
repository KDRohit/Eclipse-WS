package com.ig.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils 
{
	private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour
    
    private Key getSigningKey()
    {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
    
    public String generateToken(String username, String role)
    {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }
    
    public boolean isTokenValid(String token) {
        try 
        {
            extractClaims(token);
            return true;
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
            return false;
        }
    }
    
    
    
}
