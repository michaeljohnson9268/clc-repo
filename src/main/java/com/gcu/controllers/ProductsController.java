package com.gcu.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	ProductsBusinessServiceInterface service;
	
	
	@GetMapping("/")
	public String display(@RequestParam(value="material", required=false)ProductModel material ,Model model) 
	{

		return "dashboard";
	}
	
	@PostMapping("/displayProducts")
	public String displayProducts(Model model)
	{
		List<ProductModel> productList = new ArrayList<ProductModel>(); 
		
//		ProductModel newProduct = new ProductModel();
//		newProduct = service.findById(1);

		
//		productList.add(newProduct);
		productList = service.findAll();
		
		//Sends new product model to dashboard page.
		model.addAttribute("title", "Products");
		model.addAttribute("products", productList);
		return "displayAllProducts";
	}
	
	@PostMapping("/createProduct")
	public String createOrder(@Valid @ModelAttribute("material") ProductModel material, BindingResult bindingResult, Model model) {
		//data validation
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Create Product");
			
			return "createProduct";
		}

		
		service.insert(material);
		//Sends orders to next page
		
		List<ProductModel> productList = new ArrayList<ProductModel>(); 

		productList = service.findAll();
		
		
		
		model.addAttribute("title","My Products");
		model.addAttribute("products", productList);
		return "dashboard";

	}
	
	@GetMapping("/displayEdit/{id}")
	public String displayEdit(@PathVariable("id") String empId, Model model) {

		int prodId = Integer.parseInt(empId);
//		
		ProductModel material = service.findById(prodId);
		
		
//		//sends new material to display order page
		model.addAttribute("editProduct", material);
		model.addAttribute("title", "Edit Form");

		
		return "updateProduct";
	}
	
	@PostMapping("/doEdit")
	public String doEdit(@Valid @ModelAttribute("editProduct") ProductModel newProduct,  BindingResult bindingResult, Model model) {
		
		
	
		

		boolean isUpdated = service.edit(newProduct);

		// if there were binding errors, or product deleting error
		if (bindingResult.hasErrors() || isUpdated == false) {

			model.addAttribute("title", "Product Form");


			return "updateProduct";
		}

		List<ProductModel> productList = service.findAll();

		// pass list to view
		model.addAttribute("products", productList);
		
		// return view
		return "displayAllProducts";
	}
	
	
	@GetMapping("/delete/{id}")
    public String displayDelete(@PathVariable("id") String id, Model model) {

	    int prodId = Integer.parseInt(id);
        // Finds product with ID
        ProductModel material = service.findById(prodId);
        service.remove(material);

     // Service finds all products
        List<ProductModel> productList = service.findAll();

        // pass list to view
        model.addAttribute("products", productList);

        // return view
        return "displayAllProducts";
    }
	@PostMapping("/doDelete")
    public String doDelete(@Valid @ModelAttribute("deleteProduct") ProductModel newProduct, BindingResult bindingResult,
            Model model) {

        // Service deletes Product in database
        service.remove(newProduct);

        // Service finds all products
        List<ProductModel> productList = service.findAll();

        // pass list to view
        model.addAttribute("products", productList);

        // return view
        return "displayAllProducts";
    }
	


}
