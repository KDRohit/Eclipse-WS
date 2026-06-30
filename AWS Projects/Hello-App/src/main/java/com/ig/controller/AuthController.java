package com.ig.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.entity.Authority;
import com.ig.service.AuthorityService;

@RestController
@RequestMapping("/auth-service")
public class AuthController 
{
	@Autowired
	private AuthorityService authService;
	
   @GetMapping("/authorities")
	public List<Authority> getAll()
	{
		return authService.getAll();
	}
   
   @GetMapping("/save/{auth}")
	public String save(@PathVariable("auth") String auth)
	{
	   Authority entity = new Authority();
	   entity.role=auth;
		return authService.save(entity);
	}
}
