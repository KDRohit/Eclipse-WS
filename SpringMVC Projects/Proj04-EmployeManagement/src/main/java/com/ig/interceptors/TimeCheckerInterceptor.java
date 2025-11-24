package com.ig.interceptors;

import java.time.LocalTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeCheckerInterceptor implements HandlerInterceptor 
{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception 
	{
		LocalTime lt = LocalTime.now();
		int hours = lt.getHour();
		int min = lt.getMinute();
		if (hours>=21 && min>=35) 
		{
			 RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
			 rd.forward(req, res);
			 return false;
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler,
			ModelAndView modelAndView) throws Exception 
	{
		modelAndView.addObject("sysdate", LocalTime.now());
	}
}
