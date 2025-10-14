package com.ig.repository;

import org.springframework.data.repository.CrudRepository;

import com.ig.entity.Politician;

public interface IPoliticianRepository extends CrudRepository<Politician, Integer> 
{
	
}
