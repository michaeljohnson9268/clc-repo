package com.gcu.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.business.UsersBusinessServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;
import com.gcu.model.RegisterModel;

@Controller
@RequestMapping("/register")
public class RegisterController 
{

	//Connects the security service
	
	@Autowired
	private UsersBusinessServiceInterface users;
	
	//Shows register form
	@GetMapping("/")
	public String display(Model model) 
	{
		// Display Login Form View
		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", new RegisterModel());

		return "register";
	}
	

	//Takes you to dashboard after completing register form
	@PostMapping("/doRegister")
	public String doRegister(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
		
		//Data validation
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		}
		// creates user
		users.insert(registerModel);
		
		// finds all users
		List<RegisterModel> userList = new ArrayList<RegisterModel>(); 
		userList.add(registerModel);
		userList = users.findAll();

			
		// sends login model to login view
		model.addAttribute("loginModel", new LoginModel());
		
		return "login";

	}
	
	
}
