package com.ig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ig.entity.Authority;
import com.ig.entity.User;
import com.ig.repo.IAuthorityRepo;
import com.ig.repo.IUserRepo;

@Service
public class UserService 
{
	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public List<User> getAll()
	{
		return userRepo.findAll();
	}
	
	public String save(User data)
	{
		data.password = encoder.encode(data.password);
		User saved =  userRepo.save(data);
		return "[User :: "+saved+" saved successfully!!!]";
	}
}
