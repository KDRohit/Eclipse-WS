package com.ig.sbeans;
import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("factory")
public class AccountFactory implements FactoryBean<IAccount> 
{
	@Value("${sbeans.Account.type}")
	private String accType;
	
	@Override
	public IAccount getObject() throws Exception
	{
		if(accType.equalsIgnoreCase("sbi"))
		{
			return new SBIAccount();
		}
		else if(accType.equalsIgnoreCase("hdfc"))
		{
			return new HDFCAccount();
		}
		else
		{
			throw new InvalidAttributeValueException("application.properties have invalid account type");
		}
	}

	@Override
	public Class<IAccount> getObjectType() 
	{
		return IAccount.class;
	}
}
