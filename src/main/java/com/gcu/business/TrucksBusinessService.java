package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;
import com.gcu.model.ProductModel;
import com.gcu.model.TruckModel;

public class TrucksBusinessService implements TrucksBusinessServiceInterface {

	@Autowired
	DataAccessInterface<TruckModel> service;
	
	
	@Override
	public boolean insert(TruckModel truck) {
		// instantiates boolean
				boolean insertTruck = false;

				// integer used to create product int database
				int rows = service.create(truck);

				// checks if row has been inserted
				if (rows == 1) {

					// insert success
					insertTruck = true;
				}
				// returns boolean
				return insertTruck;
	}

	@Override
	public boolean edit(TruckModel truck) {
		// instantiate boolean
		boolean editTruck = false;

		// updates product in database
		int rows = service.update(truck);

		// if insert success
		if (rows == 1) {
			// return success
			editTruck = true;
		}

		return editTruck;

	}

	@Override
	public boolean remove(TruckModel truck) {
		// instantiate boolean
		boolean deleteTruck = false;

		// deletes product in database
		int rows = service.delete(truck);

		// if delete success
		if (rows == 1) {
			// return success, true
			deleteTruck = true;
		}

		return deleteTruck;		
	}

	@Override
	public TruckModel findById(int id) {

		// service find by id
		TruckModel newTruck = service.findById(id);

		// returns Product Model
		return newTruck;
		
	}

	@Override
	public List<TruckModel> findAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

}
