package com.ig.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ig.entity.BankAccount;
import com.ig.exceptions.CustomException;
import com.ig.repo.IBankAccountRepo;

@Service("bankAccountService")
public class BankAccountService
{
	@Autowired
	private IBankAccountRepo accountRepo;
	
	public BankAccount save(BankAccount account)
	{
		BankAccount saved =  accountRepo.save(account);
		return saved;
	}
	
	public String getBalance(Long accNum)
	{
		Optional<Double> container =  accountRepo.getBalance(accNum);
		if(container.isEmpty())
		{
			return "Account ["+accNum+"] Not Found!";
		}
		return "Account ["+accNum+"], Balance ["+container.get()+"]";
	}
	
	public String withDrawMoney(Long accNum,Double money) throws CustomException
	{
		// checking if  account exists else throw exception
		accountRepo.findById(accNum).orElseThrow(()->new CustomException("Account ["+accNum+"] Not Found!"));
		
		Optional<Integer> container =  accountRepo.withDrawMoney(accNum, money);
		if(container.isEmpty() || container.get()==0)
		{
			return "Account ["+accNum+"] Not Found!";
		}
		return "With Draw Money ["+money+"] from Account ["+accNum+"]";
	}
	
	public String withDrawMoneyWithVersioning(Long accNum,Double money) throws CustomException
	{
		// checking if  account exists else throw exception
		BankAccount bankAccountCopy =  accountRepo.findById(accNum).orElseThrow(()->new CustomException("Account ["+accNum+"] Not Found!"));
		bankAccountCopy.setBalance(bankAccountCopy.getBalance()-money);
		BankAccount bankAccountCopyUpdated = accountRepo.save(bankAccountCopy);
		return "With Draw Money ["+money+"] from Account ["+accNum+"]";
	}
	
	public String depositMoney(Long accNum,Double money) throws CustomException
	{
		// checking if  account exists else throw exception
		accountRepo.findById(accNum).orElseThrow(()->new CustomException("Account ["+accNum+"] Not Found!"));
		
		Optional<Integer> container =  accountRepo.depositMoney(accNum, money);
		if(container.isEmpty() || container.get()==0)
		{
			return "Account ["+accNum+"] Not Found!";
		}
		return "Money ["+money+"] Deposited into Account ["+accNum+"]";
	}
	
	public String depositMoneyWithVersioning(Long accNum,Double money) throws CustomException
	{
		// checking if  account exists else throw exception
		BankAccount bankAccountCopy =  accountRepo.findById(accNum).orElseThrow(()->new CustomException("Account ["+accNum+"] Not Found!"));
		bankAccountCopy.setBalance(bankAccountCopy.getBalance()+money);
		BankAccount bankAccountCopyUpdated = accountRepo.save(bankAccountCopy);
		return "Money ["+money+"] Deposited into Account ["+accNum+"]";
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String transferMoney(Long srcAccNum,Long desAccNum,Double money) throws CustomException
	{
		String msg="";
		msg+=withDrawMoneyWithVersioning(srcAccNum, money);
		msg+=depositMoneyWithVersioning(desAccNum, money);
		return msg;
	}
}
