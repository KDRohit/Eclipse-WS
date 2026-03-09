package com.ig.service;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ig.entity.QuizEntity;
import com.ig.response.Response;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilter extends OncePerRequestFilter 
{
	@Autowired ILoginService loginService;
	
	//@CircuitBreaker(name="onDoFilterInternal",fallbackMethod = "loginServiceIsBusy")
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException
	{
//		String header =  request.getHeader("Authorization");
//		Response<Boolean> result =  loginService.checkToken(header);
//		 if(result.data()==false)
//		 {
//			 ObjectMapper mapper = new ObjectMapper();
//			 String json = mapper.writeValueAsString(result);
//			 response.getWriter().write(json);
//			 return;
//		 }
		 
		 // Continue to controller
	     filterChain.doFilter(request, response);
	}

}
