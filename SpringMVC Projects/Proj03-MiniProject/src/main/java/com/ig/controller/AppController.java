package com.ig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ig.entity.Movie;
import com.ig.model.VOMovie;
import com.ig.service.MovieService;

@Controller
public class AppController 
{
	public String messageKey="message";
	
	@Autowired
	private MovieService service;
	
	@RequestMapping
	public String getFirstPage()
	{
		return "home";
	}
	
	@GetMapping("/report")
	public String gotoReportPage(Map<String, Object> map)
	{
		List<VOMovie> movies =  service.findAll();
		System.out.println(movies);
		map.put("movies", movies);
		return "report";
	}
	
	@GetMapping("/add")
	public String gotoAddPage(@ModelAttribute("movie") VOMovie vo)
	{
		return "add";
	}
	
	@GetMapping("/edit")
	public String gotoUpdatePage(@RequestParam("no") Integer no,Map<String, Object> map)
	{
		VOMovie vo = service.findById(no);
		map.put("movie", vo);
		return "edit";
	}
	
	@PostMapping("/add")
	public String postFromAddPage(@ModelAttribute("movie") VOMovie vo,
			RedirectAttributes model)
	{
		String message =  service.save(vo);
		model.addFlashAttribute(messageKey, message);
		return "redirect:report";
	}
	
	@PostMapping("/edit")
	public String postFromUpdatePage(@ModelAttribute("movie") VOMovie vo,
			RedirectAttributes model)
	{
		String message = service.update(vo);
		model.addFlashAttribute(messageKey, message);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteRequest(@RequestParam("no") Integer no,
			RedirectAttributes model)
	{
		String message = service.delete(no);
		model.addFlashAttribute(messageKey, message);
		return "redirect:report";
	}
}
