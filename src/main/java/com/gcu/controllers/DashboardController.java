package com.gcu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	

    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@GetMapping("/")
	public String display(Model model) 
	{
	    logger.debug("Dashboard working");
		return "dashboard";
	}
	
	@PostMapping("/displayProducts")
	public String displayProducts(Model model)
	{

		return "displayAllProducts";
	}


	// https://www.youtube.com/watch?v=-n1pivoLV50

	


}
