package com.ig.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsConfig
{
	@Bean
	public WebMvcConfigurer webMvcConfigurer(HandlerInterceptor[] interceptors)
	{
		WebMvcConfigurer webMvcConfig = new WebMvcConfigurer() 
		{
			public void addInterceptors(InterceptorRegistry registry) 
			{
				for(HandlerInterceptor interceptor : interceptors)
				{
					registry.addInterceptor(interceptor);
				}
			}
		};
		return webMvcConfig;
	}
}
