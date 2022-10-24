package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.ProductModel;
import com.gcu.model.RegisterModel;


/*
 * User Business Service
 */
public class UsersBusinessService implements UsersBusinessServiceInterface {
	
	// inject Data Access
	@Autowired
	DataAccessInterface<RegisterModel> service;

	/*
	 * boolean method for creating users  
	 */
	@Override
	public boolean insert(RegisterModel user) {
		// instantiate local boolean
		boolean insertProduct = false;

		// instantiate rows, using business service, creating user
		int rows = service.create(user);

		// if user is created, retuns true
		if (rows == 1) {

			// user logged in successfully
			insertProduct = true;
		}

		return insertProduct;
	}

	@Override
	public boolean edit(RegisterModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(RegisterModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/*
	 * Method return all users
	 */
	@Override
	public List<RegisterModel> findAll() {

		return service.findAll();
	}

	/*
	 * Method searches by username
	 */
	@Override
	public RegisterModel findByUsername(String username) {
		try {
			
			//Makes the list and populates it
			List<RegisterModel> users = new ArrayList<RegisterModel>();
			users = service.findAll();

			//Sets an id that cannot be in the database
			int id = -1;

			//Goes through the list
			for (RegisterModel var : users)

			{

				if (var.getCredentials().getUsername().equals(username)) {

					//Finds the id if there is one
					id = var.getUserId();

					break;

				}
				
			}

			//Makes a new user
			// Puts the Id in and the user with the id will be located
			RegisterModel newUser = service.findById(id);

			//Returns the user
			return newUser;
		}
		catch (Exception e) {
			return null;
		}
	}

}
