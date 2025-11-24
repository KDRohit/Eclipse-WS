package com.ig.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ig.interceptors.TimeCheckerInterceptor;

@Component
public class MyWebMVCWebConfigurer implements WebMvcConfigurer 
{
	@Autowired
	public TimeCheckerInterceptor tmchkInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) 
	{
		registry.addInterceptor(tmchkInterceptor);
	}
	
}
