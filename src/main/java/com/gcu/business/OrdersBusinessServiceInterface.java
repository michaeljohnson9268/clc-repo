package com.gcu.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.OrderModel;

@Service
public interface OrdersBusinessServiceInterface {
	// CRUD methods
		public boolean insert(OrderModel order);
		public boolean edit(OrderModel order);
		public boolean remove(OrderModel order);
		public OrderModel findById(int id);
		public List<OrderModel> findAll();
}
