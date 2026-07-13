package com.ig.config;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig 
{	
	Converter<Jwt, Collection<GrantedAuthority>> getAWSRolesConverter()
	{
		Converter<Jwt, Collection<GrantedAuthority>> awsRolesConverter = (Jwt jwt)->
		{
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			List<String> groups = jwt.getClaimAsStringList("cognito:groups");
			
			if (groups == null)
				return authorities;
			
			 groups.forEach
			 (
					 group ->
					 				authorities.add(new SimpleGrantedAuthority("ROLE_" + group.toUpperCase()))
			 );
			return authorities;
		};
		return awsRolesConverter;
	}
		
	Converter<Jwt, Collection<GrantedAuthority>> getCloakRolesConverter()
	{
		Converter<Jwt, Collection<GrantedAuthority>> keyCloakRolesConverter =
		(Jwt jwt)->
		{
			List<GrantedAuthority> authorities = new ArrayList<>();
			Map<String, Object> realmAccess = jwt.getClaim("realm_access");
			 
			 if (realmAccess == null)
		            return authorities;

		        List<String> roles = (List<String>) realmAccess.get("roles");

		        if (roles == null)
		            return authorities;

		        roles.forEach(role ->authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
			 
			return authorities;
			
		};
		return keyCloakRolesConverter;
	}
	
	
	AuthenticationEntryPoint getAuthenticationEntryPoint()
	{
		AuthenticationEntryPoint authenticationEntryPoint = (request, response, authException) ->
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json");
			
			response.getWriter().write
			(
					"""
					{
		                "status": 401,
		                "error": "Unauthorized",
		                "message": "Authentication required"
					 }
					"""
			);
			
		};
		return authenticationEntryPoint;
	}
	
	AccessDeniedHandler getCustomAccessDeniedHandler()
	{
		AccessDeniedHandler adh =
				(request, response, accessDeniedException)->
		{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.setContentType("application/json");
			response.getWriter().write("""
					 		{
				                "status": 403,
				                "error": "Unauthorized",
				                "message": "Access denied"
					        }
					""");
					
		};
		return adh;
	}
	
	@Bean
	JwtAuthenticationConverter jwtAuthenticationConverter() 
	{
	    JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
	    converter.setJwtGrantedAuthoritiesConverter(getAWSRolesConverter());
	    return converter;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.authorizeHttpRequests
		(
				auth->
				{
					auth.requestMatchers("/security/public").permitAll()
					.requestMatchers("/security/create/**").permitAll()
					.requestMatchers("/security/token/**").permitAll()
					.requestMatchers("/security/secrethash/**").permitAll()
					.requestMatchers("/security/user").hasAnyRole("user","USER")
					.requestMatchers("/security/admin").hasAnyRole("admin","ADMIN")
					;
				}
		)
		.exceptionHandling
		(
				e->
				{
					e.accessDeniedHandler(getCustomAccessDeniedHandler());
					e.authenticationEntryPoint(getAuthenticationEntryPoint());
				}
		)
		.formLogin(Customizer.withDefaults())
		.oauth2ResourceServer
		(
				oauth->
				{
					oauth.jwt(Customizer.withDefaults());
				}
		);
		return httpSecurity.build();
	}
}
