package com.ig.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPlayerRepo extends JpaRepository<Player, Integer> 
{
	
}
