package com.ig.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter
{
	@Autowired
	private JwtUtils jwtUtils;
	
	private static final String AUTH_KEY  = "Authorization";
	private static final String AUTH_STARTS_WITH = "Bearer ";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		// getting header ...
		String authHeader =  request.getHeader(AUTH_KEY);
		
		// checking if null or not starting with bearer...
		if(authHeader!=null && authHeader.startsWith(AUTH_STARTS_WITH))
		{
			String token = authHeader.substring(7);
			if(jwtUtils.isTokenValid(token))
			{
				String username = jwtUtils.extractUsername(token);
				String role = jwtUtils.extractRole(token);
				
				List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("Role_"+role));
				
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
						
			}
			else
			{
				System.out.println("Invalid token :: "+token);
			}
			
			filterChain.doFilter(request, response);
		}
	}

}
