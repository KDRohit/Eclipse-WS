package com.ig.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ig.entity.User;
import com.ig.repo.IUserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private IUserRepo repo ;
	
	@Autowired
	ApplicationContext ctx;
	
	com.ig.session.UserDetails loginUser = null;
	
	public com.ig.session.UserDetails getLoginUser()
	{
		return loginUser;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = repo.findByName(username)
				.orElseThrow
				(
						()->new UsernameNotFoundException(username+" not found !!!")
				);
		
		loginUser = ctx.getBean(com.ig.session.UserDetails.class);
		
		loginUser.name = user.name;
		loginUser.password = user.password;
		
		return org.springframework.security.core.userdetails.User
                .withUsername(user.name)
                .password(user.password)
                .authorities(user.authority.role)
                .build();
	}
}
