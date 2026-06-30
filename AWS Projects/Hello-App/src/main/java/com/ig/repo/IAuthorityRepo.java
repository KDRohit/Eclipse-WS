package com.ig.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ig.entity.Authority;

@Repository
public interface IAuthorityRepo extends JpaRepository<Authority, Integer> 
{
	
}
