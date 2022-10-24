package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Autowired
	DataAccessInterface<OrderModel> service;
	
	@Override
	public boolean insert(OrderModel order) {
		// instantiates boolean
				boolean insertProduct = false;

				// integer used to create product int database
				int rows = service.create(order);

				// checks if row has been inserted
				if (rows == 1) {

					// insert success
					insertProduct = true;
				}
				// returns boolean
				return insertProduct;
	}

	@Override
	public boolean edit(OrderModel order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(OrderModel order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> findAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

}
