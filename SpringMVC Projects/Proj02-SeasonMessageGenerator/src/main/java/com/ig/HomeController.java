package com.ig;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController 
{
	String getSeason()
	{
		LocalDate ld = LocalDate.now();
		int month = ld.getMonthValue();
		if(month>3 && month<=6)
		{
			return "Season:Summer";
		}
		else if(month>7 && month<=10) 
		{
			return "Season:Monsoon";
		}
		else
		{
			return "Season:Winter";
		}
	}
	
	
	@GetMapping("/")
	public String showDynamicHomePage()
	{
		return "seasonfinder";
	}
	
	@GetMapping("/findSeason")
	public String showDynamicHomePage(Map<String, Object> map)
	{
		String msg = getSeason();
		map.put("message",msg);
		return "seasonfinderresult";
	}
	
	@PostMapping("/dataBinding")
	public String printDataBinding(
			Map<String, Object> map,
			HttpServletRequest req,
			HttpServletResponse res,
			@ModelAttribute("someDummyModel")DummyModel dm,
			@ModelAttribute("someDummyModel2")DummyModel2 dm2,
			@ModelAttribute("someDummyModel3")DummyModel3 dm3,
			@RequestParam(value="username",required = false,defaultValue = "default") String uname,
			@RequestParam(value="password",required = false,defaultValue = "default") String pass
			)
	{
		String userName =  req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("Username: "+userName);
		System.out.println("Password: "+password);
		
		System.out.println("------Model Attribute-----------");
		System.out.println(dm);
		System.out.println(dm2);
		System.out.println(dm3);
		
		System.out.println("------Request Param-----------");
		System.out.println(uname);
		System.out.println(pass);
		
		System.out.println("------Service Logic-----------");
		String msg = getSeason();
		map.put("message",msg);
		map.put("Array",new String[] {"data1","data2","data3"});
		map.put("List",List.of(1,2,3,4));
		map.put("Set",Set.of(1,2,3,4));
		map.put("Map",Map.of("aadhar","121232324344","voterid","dfdfdf"));
		return "forward:seasonfinderresult";
	}
}
