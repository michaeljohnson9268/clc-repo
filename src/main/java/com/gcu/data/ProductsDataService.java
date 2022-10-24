package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.ProductModel;

@Service
public class ProductsDataService implements DataAccessInterface<ProductModel> {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/*
	 * Non Default contructor for constructor injection
	 */

	public ProductsDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	// CRUD: finder to return all entities
	@Override
	public List<ProductModel> findAll() {
		String sql = "SELECT * FROM products";
		List<ProductModel> orders = new ArrayList<ProductModel>();

		try {
			// Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next()) {
				orders.add(new ProductModel(srs.getInt("productId"),
											srs.getString("productColor"),
											srs.getString("productSize"),
											srs.getFloat("price")));
			}
		} catch (Exception c) {
			c.printStackTrace();
		}

		return orders;

	}
	

	@Override
	public ProductModel findById(int id) {
		
		//Sets the query
		String sql = "SELECT * FROM products WHERE `productId` = ?";
		
		//Creates product
		ProductModel newProduct = null;
		
		try {
			
			//find the correct id
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, id);
			
			while(srs.next()) {
				//Sets the product
				newProduct = new ProductModel(srs.getInt("productId"), 
											  srs.getString("productColor"), 
											  srs.getString("productSize"), 
											  srs.getFloat("price"));
			}
		}
		
		
		catch(Exception ex) {
			return null;
		}
		

		//Returns the product
		return newProduct;
	
	}

	@Override
	public int create(ProductModel orders) {


		try {
			
			//Creates the SQL
			String sql = "INSERT INTO products(productColor, productSize, price) VALUES(?, ?, ?)";

			//Inserts the row
			int rows = jdbcTemplateObject.update(sql,
											orders.getProductColor(),
											orders.getProductSize(),
											orders.getProductPrice());

			if(rows == 0) {
				//if no row was inserted, return 0
				return 0;
			}
		} catch (Exception c) {
			c.printStackTrace();
			return -1;

		}

		return 1;
	}

	@Override
	public int update(ProductModel product) {
		
		try {
			
			//Sets the SQL
			String sql = "UPDATE products SET productId = ?, productSize = ?, productColor = ?, price = ? WHERE productId = ?";
			
			//Makes the inserted row
			int rowInserted = jdbcTemplateObject.update(sql, product.getProductId(),
															 product.getProductSize(), 
															 product.getProductColor(), 
															 product.getProductPrice(), 
															 product.getProductId());

			
			
			if (rowInserted == 0) {
				// if no row was inserted, return 0
				return 0;
			}
		} catch (Exception ex) {
			return -1;
		}
		// if new row was inserted we return 1
		return 1;
	}

	@Override
	public int delete(ProductModel product) {
		try {
			String sql = "DELETE FROM `products` WHERE `productId` = ?";
			int rowInserted = jdbcTemplateObject.update(sql, product.getProductId());

			if (rowInserted == 0) {
				// if no row was inserted, return 0
				return 0;
			}
		} catch (Exception e) {
			return -1;
		}
		// if new row was inserted we return 1
		return 1;
	}

}
