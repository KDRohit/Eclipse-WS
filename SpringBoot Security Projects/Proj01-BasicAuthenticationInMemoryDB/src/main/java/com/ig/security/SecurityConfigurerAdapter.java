package com.ig.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter 
{
	@Autowired
	private DataSource ds;
	
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception 
	{
//		authManagerBuilder
//		.inMemoryAuthentication()
//		.withUser("kamla")
//		.password("{noop}1234")
//		.roles("everyone");
//		
//		authManagerBuilder
//		.inMemoryAuthentication()
//		.withUser("riya")
//		.password("{noop}1234")
//		.roles("authenticated");
//		
//		authManagerBuilder
//		.inMemoryAuthentication()
//		.withUser("rohit")
//		.password("{noop}1234")
//		.roles("authorized");
		
//		authManagerBuilder.
//		inMemoryAuthentication().
//		passwordEncoder(new BCryptPasswordEncoder()).
//		withUser("kamla").
//		password("$2a$10$FkoPxfOZ7fn0eFc2dkKoue8C1FAjScqoosMsEDB.tI/uNgsL7ahLS").
//		roles("everyone");
//		
//		authManagerBuilder.
//		inMemoryAuthentication().
//		passwordEncoder(new BCryptPasswordEncoder()).
//		withUser("rohit").
//		password("$2a$10$cgiWgJU23meZfw4NbR2UBONWB3.uvexcQ8S3qe0y1/5YmvlLBS./O").
//		roles("authorized");
//		
//		authManagerBuilder.
//		inMemoryAuthentication().
//		passwordEncoder(new BCryptPasswordEncoder()).
//		withUser("riya").
//		password("$2a$10$CM5DOjH/MbMhbTx6hSO0SOXvVLq2Yg8KBo9mzK7rxtP3nW1mabocW").
//		roles("authenticated");
		
		authManagerBuilder
		.jdbcAuthentication()
		.dataSource(ds)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("select email,password,status from users where email=?")
		.authoritiesByUsernameQuery("select email,role from user_roles where email=?");
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception 
	{
		httpSecurity
		.authorizeHttpRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/only_authenticated").authenticated()
		.antMatchers("/only_authorized").hasAnyAuthority("authorized","everyone")
		.anyRequest().permitAll()
		.and()
		//.httpBasic()
		.formLogin()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		.and()
		.logout()
		.and()
		.sessionManagement()
		.maximumSessions(1)
		.maxSessionsPreventsLogin(true)
		;
	}
}
