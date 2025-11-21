package com.ig.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
public class MovieException extends RuntimeException
{
	public MovieException()
	{
		super();
	}
	public MovieException(String msg)
	{
		super(msg);
	}
	
}
