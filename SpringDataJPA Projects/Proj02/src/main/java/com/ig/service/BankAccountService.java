package com.ig.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.repo.IBankAccountRepo;

import jakarta.transaction.Transactional;

@Service("bankAccountService")
public class BankAccountService
{
	@Autowired
	private IBankAccountRepo accountRepo;
	
	public String getBalance(Long accNum)
	{
		Optional<Double> container =  accountRepo.getBalance(accNum);
		if(container.isEmpty())
		{
			return "Account ["+accNum+"] Not Found!";
		}
		return "Account ["+accNum+"], Balance ["+container.get()+"]";
	}
	
	public String withDrawMoney(Long accNum,Double money)
	{
		Optional<Integer> container =  accountRepo.withDrawMoney(accNum, money);
		if(container.isEmpty() || container.get()==0)
		{
			return "Account ["+accNum+"] Not Found!";
		}
		return "With Draw Money ["+money+"] from Account ["+accNum+"]";
	}
	
	public String depositMoney(Long accNum,Double money)
	{
		Optional<Integer> container =  accountRepo.depositMoney(accNum, money);
		if(container.isEmpty() || container.get()==0)
		{
			return "Account ["+accNum+"] Not Found!";
		}
		return "Money ["+money+"] Deposited into Account ["+accNum+"]";
	}
	
	@Transactional
	public String transferMoney(Long srcAccNum,Long desAccNum,Double money)
	{
		String msg="";
		msg+=depositMoney(desAccNum, money);
		msg+=withDrawMoney(srcAccNum, money);
		return msg;
	}
}
