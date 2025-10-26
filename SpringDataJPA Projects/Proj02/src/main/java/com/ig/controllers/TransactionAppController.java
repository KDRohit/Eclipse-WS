package com.ig.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import com.ig.entity.BankAccount;
import com.ig.entity.Movie;
import com.ig.service.BankAccountService;

@Controller("transactionController")
@Profile({"account-in-mysql","account-in-oracle"})
public class TransactionAppController implements AppController
{
	@Autowired
	private BankAccountService bankAccountService;
	
	@Override
	public void showMenu(boolean isFirst) 
	{
		if(isFirst)
		{
			System.out.println("Welcome in the app:-\n ------TransactionManagement-------------");
		}
		System.out.println("Menu(Items):-");
		System.out.println("1)- Check Balance                                                                           [SELECTION(CRUD)]");
		System.out.println("2)- Create Account                                                                          [SELECTION(CRUD)]");
		System.out.println("3)- With Draw Money                                                                    [UPDATE(CRUD)]");
		System.out.println("4)- Deposit Money                                                                         [UPDATE(CRUD)]");
		System.out.println("5)- Transfer Money                                                                         [UPDATE(CRUD)]");
		getAndProcessInput();
	}

	@Override
	public void getAndProcessInput() 
	{
		int ch = getInput("Enter option:-", 0);
		long SourceAccountNum;
		long DestinationAccountNum;
		double money;
		try
		{
			switch (ch) 
			{
				case 1:
				SourceAccountNum = getInput("Enter Account Number:-",0 );
				System.out.println(bankAccountService.getBalance(SourceAccountNum));
				showMenu(false);
				break;
				
				case 2:
					BankAccount account = getBankAccount();
					BankAccount saved = bankAccountService.save(account);
					System.out.println("Account Opened :: "+saved);
					showMenu(false);
					break;
					
				case 3:
					SourceAccountNum = getInput("Enter Account Number:-",0 );
					money =  getInput("Enter Amount (WithDraw):-",0 );
					System.out.println(bankAccountService.withDrawMoney(SourceAccountNum,money));
					showMenu(false);
					break;
					
				case 4:
					SourceAccountNum = getInput("Enter Account Number:-",0 );
					money =  getInput("Enter Amount (Deposit):-",0 );
					System.out.println(bankAccountService.depositMoney(SourceAccountNum,money));
					showMenu(false);
					break;
					
				case 5:
					SourceAccountNum = getInput("Enter Account Number (WithDraw):-",0 );
					DestinationAccountNum = getInput("Enter Account Number (Deposit):-",0 );
					money =  getInput("Enter Amount (Deposit):-",0 );
					System.out.println(bankAccountService.transferMoney(SourceAccountNum,DestinationAccountNum,money));
					showMenu(false);
					break;
			}
		}
		catch (Exception e)
		{
			System.out.println("\n Error [Message] : "+e.getMessage());
			showMenu(false);
		}
	}
	
	private BankAccount getBankAccount()
	{
		String name = getInput("Enter Holder name:-", "");
		long amount = getInput("Enter Amount :-", 0);
		/*
		 * int year = getInput("Enter release year", 0); int month =
		 * getInput("Enter release month", 0); int day = getInput("Enter release day",
		 * 0); LocalDate date = LocalDate.of(year, month, month);
		 */
		return new BankAccount(name,amount);
	}

}
