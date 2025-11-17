package com.ig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.mysql.DBAccount1;
import com.ig.entity.oracle.DBAccount2;
import com.ig.repo.mysql.IDBAccount1Repo;
import com.ig.repo.oracle.IDBAccount2Repo;

@Service
public class AccountService 
{
	@Autowired
	private IDBAccount1Repo repo1;
	
	//@Autowired
	//private IDBAccount2Repo repo2;
	
	public String save(DBAccount1 entity1,DBAccount2 entity2)
	{
		DBAccount1 savedEntity1 = repo1.save(entity1);
		//DBAccount2 savedEntity2 = repo2.save(entity2);
		return "Entity1 ["+savedEntity1.getId()+"], Entity2 ["+savedEntity1.getId()+"] saved";
	}
}
