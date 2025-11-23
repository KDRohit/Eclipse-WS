package com.ig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ig.model.EmpVO;
import com.ig.service.EmpService;

@Controller
public class EmployeeController
{
	@Autowired
	private EmpService service;
	
	public String messageKey = "message";
	public String empVOKey = "empVO";
	public String empListVOKey =  "empVOList";
	
	@GetMapping
	public String gotoFirstPage()
	{
		return "index";
	}
	
	@GetMapping("/Employees")
	public String getEmployees(Map<String, Object> map)
	{
		List<EmpVO> list = service.findAll();
		map.put(empListVOKey, list);
		return "employee";
	}
	
	@GetMapping("/addEmployee")
	public String getAddEmployee(@ModelAttribute("empVO") EmpVO emp)
	{
		return "addEmployee";
	}
	
	@PostMapping("/addEmployee")
	public String postAddEmployee(
			@ModelAttribute("empVO")EmpVO emp,
			Map<String, Object> map,
			RedirectAttributes attr
			)
	{
		String msg = service.save(emp);
		attr.addFlashAttribute(messageKey, msg);
		return "redirect:Employees";
	}
	
	@GetMapping("/editEmployee")
	public String getEditEmployee(
			@RequestParam("id") Integer id,
			Map<String, Object> map
			)
	{
		EmpVO vo =  service.findVOById(id);
		map.put(empVOKey, vo);
		return "editEmployee";
	}
	
	@PostMapping("/editEmployee")
	public String postEditEmployee(
			@ModelAttribute("empVO")EmpVO emp,
			RedirectAttributes attr
			)
	{
		String msg = service.edit(emp);
		attr.addFlashAttribute(messageKey, msg);
		return "redirect:Employees";
	}
	
	@GetMapping("/deleteEmployee")
	public String getDeleteEmployee(
			@RequestParam("id")Integer id,
			RedirectAttributes attr
			)
	{
		String msg = service.delete(id); 
		attr.addFlashAttribute(messageKey, msg);
		return "redirect:Employees";
	}
}
