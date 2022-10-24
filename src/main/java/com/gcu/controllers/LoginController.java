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
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/login")
public class LoginController {
	// Connects security service
	@Autowired
	private SecurityBusinessService security;

	// Connects business interface
	@Autowired
	private ProductsBusinessServiceInterface products;

	@GetMapping("/")
	public String display(@RequestParam(value = "loginModel", required = false) LoginModel login, Model model) {
		// Display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());

		return "login";
	}

	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		System.out.println(String.format("Form with username of %s and Password of %s", loginModel.getUsername(),
				loginModel.getPassword()));

		
		
		// Data validation
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		//Checking for the username and password
		else if (security.authenticate(loginModel.getUsername(), loginModel.getPassword()) != true) {
			
			//Restarts page if the information is not correct
			model.addAttribute("title", "Login Form");			
			return "login";
			
		}
		
		//Continues to the next page 
		else {
			
			//Makes the product list
			List<ProductModel> productList = new ArrayList<ProductModel>();
			
			//Populated the product list
			productList = products.findAll();

			// Sends products to next page
			model.addAttribute("title", "My Products");
			model.addAttribute("material", new ProductModel());
			model.addAttribute("products", productList);

			return "dashboard";
		}
	}
}
