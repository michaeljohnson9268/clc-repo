package com.gcu.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.TruckModel;

@Service
public interface TrucksBusinessServiceInterface {
	// CRUD methods
		public boolean insert(TruckModel truck);
		public boolean edit(TruckModel truck);
		public boolean remove(TruckModel truck);
		public TruckModel findById(int id);
		public List<TruckModel> findAll();
}
