package com.ig.controller;

import java.util.List;

import com.ig.entity.Authority;
import com.ig.entity.User;
import com.ig.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAll()
	{
		return userService.getAll();
	}
	
	@GetMapping("/save/{name}/{pass}/{role}")
	public String save(
			@PathVariable("name") String name, 
			@PathVariable("pass") String pass, 
			@PathVariable("role") String role)
	{
		User u = new User();
		u.name = name;
		u.password = pass;
		u.status=true;
		
		Authority auth = new Authority();
		auth.role = role;
		
		u.authority = auth;
		
		return userService.save(u);
	}
}
