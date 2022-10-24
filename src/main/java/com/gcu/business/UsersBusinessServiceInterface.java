package com.gcu.business;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gcu.model.RegisterModel;

/*
 * User Business Service Interface
 */
@Service
public interface UsersBusinessServiceInterface {

	// CRUD methods
	public boolean insert(RegisterModel user);
	public boolean edit(RegisterModel user);
	public boolean remove(RegisterModel user);
	public RegisterModel findByUsername(String username);
	public List<RegisterModel> findAll();
}
