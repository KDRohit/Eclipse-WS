package com.ig.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("hdfc")
@ToString
public class HDFCAccount implements IAccount
{
	@Value("${sbeans.HDFCAccount.accountNo}")
	private String accountNo;

	@Override
	public String getAccount()
	{
		return accountNo;
	}
}
