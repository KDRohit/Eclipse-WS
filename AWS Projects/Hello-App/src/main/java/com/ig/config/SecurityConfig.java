package com.ig.config;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails user = 
//				User.
//				builder().
//				username("user").
//				password("{noop}1234")
//				.roles("user")
//				.build();
//		
//		UserDetails admin = 
//				User.
//				builder().
//				username("admin").
//				password("{noop}1234")
//				.roles("admin")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.authorizeHttpRequests
		(
				auth->
				auth
				.requestMatchers("/test-service/art").hasRole("art")
				.requestMatchers("test-service/dev").hasRole("dev")
				.anyRequest().permitAll()
		)
		.formLogin()
		.and()
		.logout(
				logout ->
				     logout.logoutUrl("/test-service/logout")
					.logoutSuccessUrl("/test-service/art")
					.deleteCookies("JSESSIONID")
					.invalidateHttpSession(true)
					.permitAll()
				);
		return httpSecurity.build();
	}
}
