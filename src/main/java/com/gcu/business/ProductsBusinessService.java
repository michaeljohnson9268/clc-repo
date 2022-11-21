package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.controllers.ProductsController;
import com.gcu.data.DataAccessInterface;
import com.gcu.model.ProductModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// product business service implements interface
public class ProductsBusinessService implements ProductsBusinessServiceInterface {

    
    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

	// injects data access service
	@Autowired
	DataAccessInterface<ProductModel> service;

	/*
	 * Method creates user, retunrs boolean
	 */
	@Override
	public boolean insert(ProductModel product) {
		// instantiates boolean
		boolean insertProduct = false;

		// integer used to create product int database
		int rows = service.create(product);

		// checks if row has been inserted
		if (rows == 1) {
            logger.debug("Product Inserted Successfully  {}", product);

			// insert success
			insertProduct = true;
		}
		// returns boolean
		return insertProduct;
	}

	/*
	 * Methods returns Product Model with selected id
	 */
	@Override
	public ProductModel findById(int id) {

		// service find by id
		ProductModel newProduct = service.findById(id);
		logger.debug("Product Found By ID  {}", newProduct);
		// returns Product Model
		return newProduct;

	}

	/*
	 * Selects all products, returns list
	 */
	@Override
	public List<ProductModel> findAll() {
	    logger.debug("Product Service Finding all");
		// return Product Model List
		return service.findAll();
	}

	// Method to update Product Model in database
	@Override
	public boolean edit(ProductModel product) {

		// instantiate boolean
		boolean editProduct = false;

		// updates product in database
		int rows = service.update(product);

		// if insert success
		if (rows == 1) {
		    logger.debug("Product Edited Successfully  {}", product);
			// return success
			editProduct = true;
		}

		return editProduct;

	}

	/*
	 * Method to delete product From Database
	 */
	@Override
	public boolean remove(ProductModel product) {
		
		// instantiate boolean
		boolean deleteProduct = false;

		// deletes product in database
		int rows = service.delete(product);

		// if delete success
		if (rows == 1) {
		    logger.debug("Product Deleted Successfully  {}", product);
			// return success, true
			deleteProduct = true;
		}

		return deleteProduct;
	}



}
