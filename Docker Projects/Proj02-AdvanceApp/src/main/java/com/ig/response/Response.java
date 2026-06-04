package com.ig.response;
import java.io.Serializable;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Response<T> implements  Serializable
{
	public Integer code;
	public String message;
	public T data;
}
