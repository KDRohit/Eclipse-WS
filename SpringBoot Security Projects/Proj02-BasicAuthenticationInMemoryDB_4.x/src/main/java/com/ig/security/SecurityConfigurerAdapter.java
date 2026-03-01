package com.ig.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigurerAdapter
{
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SecurityFilterChain securityChainFilter(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.authorizeHttpRequests(requests->{
			requests.requestMatchers("/","/login/**").permitAll()
			.requestMatchers("/only_authenticated").authenticated()
			.requestMatchers("/only_authorized").hasAnyAuthority("authorized","everyone")
			.anyRequest().permitAll();
		})
		.formLogin(Customizer.withDefaults())
		.oauth2Login(Customizer.withDefaults())
		;
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder)
	{
		//UserDetails user1 =  User.withUsername("rohit").password(passwordEncoder.encode("rohit")).roles("authorized").build();
		//UserDetails user2 =  User.withUsername("kamla").password(passwordEncoder.encode("kamla")).roles("everyone").build();
		//UserDetails user3 =  User.withUsername("riya").password(passwordEncoder.encode("riya")).roles("authenticated").build();
		//return new InMemoryUserDetailsManager(user1,user2,user3);
		 JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		 return jdbcUserDetailsManager;
	}
}
