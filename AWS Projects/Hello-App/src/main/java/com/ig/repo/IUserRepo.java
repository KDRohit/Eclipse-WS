package com.ig.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ig.entity.User;

public interface IUserRepo extends JpaRepository<User, Integer> 
{
	public Optional<User> findByName(String name);
}
