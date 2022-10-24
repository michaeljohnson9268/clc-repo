package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderModel {
	//Creates variables
	private int id;
	
	private int customer;

	private String orderNumber;
	
	@NotNull(message="Quantity is a required field")
	@Size(min=1, max=32, message="Quantity must be between 1 and 32 characters")
	private int quantity;

	
	private int product;

	// default constructor
	public OrderModel() {
		this.id = 0;
		orderNumber = "";
		this.customer = 0;
		this.product = 0;
		this.quantity = 0;
	}

	//Constructor
	public OrderModel(int id, String orderNumber, int customer, int product,
			@NotNull(message = "Quantity is a required field") @Size(min = 1, max = 32, message = "Quantity must be between 1 and 32 characters") int quantity) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	
	
	
}
