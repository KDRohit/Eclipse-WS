package com.ig.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.dao.IDAO;

import lombok.ToString;

@Service("service")
@ToString
public class DAOService
{
	@Autowired
	private IDAO dao;
	
}
