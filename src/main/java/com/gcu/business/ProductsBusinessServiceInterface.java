package com.gcu.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.ProductModel;

/*
 * interface for products business service
 */
@Service
public interface ProductsBusinessServiceInterface {

	// CRUD methods
	public boolean insert(ProductModel product);
	public boolean edit(ProductModel product);
	public boolean remove(ProductModel product);
	public ProductModel findById(int id);
	public List<ProductModel> findAll();

	
}
