package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;

@Service
public class SecurityBusinessService {

	@Autowired
	private UsersBusinessServiceInterface usersData;

	// Currently shows that the security has been activated
	// in the future will have ability to confirm correct log in info was provided
	public boolean authenticate(String username, String password) {

		// Creates the user
		// Searches for the username
		try {
			
			//If it does not return a username then the user is empty
			//Data validation makes you enter a password
			//There is no way to input an empty password and get through
			RegisterModel user = usersData.findByUsername(username);

			//checks the password 
			//Returns true if there is a password
			if (user.getCredentials().getPassword().equals(password)) {
				
				return true;
				
			} 
			
			else {
				
				return false;
				
			}
		} 
		
		
		catch (Exception e) {
			
			return false;
		}

	}
}
