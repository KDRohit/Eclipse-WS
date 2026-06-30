package com.ig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig 
{	
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
				                "message": "Access denied"
					        }
					""");
					
		};
		return adh;
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.authorizeHttpRequests
		(
				auth->
				{
					auth.requestMatchers("/test/public").permitAll()
					.requestMatchers("/test/user").authenticated()
					.requestMatchers("/test/admin").hasRole("admin");
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
