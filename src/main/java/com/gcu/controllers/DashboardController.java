package com.gcu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	

	
	
	@GetMapping("/")
	public String display(Model model) 
	{

		return "dashboard";
	}
	
	@PostMapping("/displayProducts")
	public String displayProducts(Model model)
	{

		return "displayAllProducts";
	}


	// https://www.youtube.com/watch?v=-n1pivoLV50

	


}
