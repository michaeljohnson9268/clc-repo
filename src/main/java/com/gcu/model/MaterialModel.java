package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MaterialModel {
	//Creates variables
	private Long id;
	private String orderNo;
	private String customer;
	private String productColor;
	private String productSize;
	
	private float price;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private int quantity;

	public MaterialModel() {

	}

	//Constructor
	public MaterialModel(Long id, String orderNo, String customer, String productColor, String productSize, float price,
			int quantity) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.customer = customer;
		this.productColor = productColor;
		this.productSize = productSize;
		this.price = price;
		this.quantity = quantity;
	}


	// auto generated getters and setters for username and password
	
	public String getCustomer() {
		return customer;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}



	public String getProductColor() {
		return productColor;
	}



	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}



	public String getProductSize() {
		return productSize;
	}



	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productColor;
	}

	public void setProductName(String productName) {
		this.productColor = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
