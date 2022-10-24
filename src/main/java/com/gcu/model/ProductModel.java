package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductModel {
	// Creates variables
	private int productId;
	@NotNull(message="Product Color is a required field")
	@Size(min=1, max=32, message="Color must be between 1 and 32 characters")
	private String productColor;
	@NotNull(message="Product Size is a required field")
	@Size(min=1, max=32, message="Size must be between 1 and 32 characters")
	private String productSize;
	
	@NotNull(message="Product Price is a required field")
	@Min(value=0, message="must be equal or greater than 18")  
	private float productPrice;

	public ProductModel() {
		this.productId = 0;
		this.productColor = "";
		this.productSize = "";
		this.productPrice = 0;
	}



	public ProductModel(int i, String productColor, String productSize, float price) {
		super();
		this.productId = i;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productPrice = price;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public float getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}



	@Override
	public String toString() {
		return "ID: " + productId + ", Color: " + productColor + ", Size: "
				+ productSize + ", Price: " + productPrice;
	}



	

}
