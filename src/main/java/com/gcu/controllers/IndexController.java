package com.gcu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController 
{
	//the fist page you land on when going to the website
	@GetMapping("/")
	public String display(Model model) 
	{
	    
		// Display register Form View
		model.addAttribute("title", "");


		return "index";
	}
}
