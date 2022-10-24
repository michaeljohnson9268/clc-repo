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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	OrdersBusinessServiceInterface orders;
	
	@Autowired
	ProductsBusinessServiceInterface products;
	
	
	
	@PostMapping("/")
	public String display(Model model) 
	{
		List<ProductModel> productList = new ArrayList<ProductModel>();
		productList = products.findAll();
		model.addAttribute("products", productList);
		return "orders";
	}
	
	@PostMapping("/displayOrders")
	public String displayOrders(Model model)
	{
		List<OrderModel> orderList = new ArrayList<OrderModel>(); 
		List<OrderModel> prodOrderList = new ArrayList<OrderModel>(); 
//		ProductModel newProduct = new ProductModel();
//		newProduct = service.findById(1);

		
//		productList.add(newProduct);
		orderList = orders.findAll();
		
		
		for(OrderModel order: orderList)
		{
			ProductModel product = new ProductModel();
			product = products.findById(order.getProduct());
			order.setProduct(product.getProductId());
			prodOrderList.add(order);
		}
		//Sends new product model to dashboard page.
		model.addAttribute("title", "Products");
		model.addAttribute("orders", prodOrderList);
		return "displayAllOrders";
	}
	
	@PostMapping("/selectProduct")
	public String selectProduct(Model model)
	{
		List<ProductModel> productList = new ArrayList<ProductModel>(); 
		
//		ProductModel newProduct = new ProductModel();
//		newProduct = service.findById(1);

		
//		productList.add(newProduct);
		productList = products.findAll();
		
		//Sends new product model to dashboard page.
		model.addAttribute("title", "Products");
		model.addAttribute("products", productList);
		return "selectProduct";
		
	}
	
	@GetMapping("/selectedProduct/{id}")
	public String displayProduct(@PathVariable("id") String empId, Model model) {

		int prodId = Integer.parseInt(empId);
//		
		ProductModel product = products.findById(prodId);
		OrderModel newOrder = new OrderModel(0,"Yard Stock",1,prodId,0);
		
//		//sends new material to display order page
		model.addAttribute("newOrder", newOrder);
		model.addAttribute("title", "Edit Form");

		
		return "createOrder";
	}
	
	@PostMapping("/createOrder")
	public String createOrder(@ModelAttribute("material") OrderModel material, BindingResult bindingResult, Model model) {
		//data validation
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Create Product");
			return "createProduct";
		}

		
		orders.insert(material);
		//Sends orders to next page
		
		List<OrderModel> orderList = new ArrayList<OrderModel>(); 

		orderList = orders.findAll();
		
		
		model.addAttribute("title","My Products");
		model.addAttribute("products", orderList);
		return "orders";

	}
}
