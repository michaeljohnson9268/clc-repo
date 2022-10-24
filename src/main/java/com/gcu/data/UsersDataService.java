package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.LoginModel;
import com.gcu.model.ProductModel;
import com.gcu.model.RegisterModel;

/*
 * Service for users
 */
@Service
public class UsersDataService implements DataAccessInterface<RegisterModel> {

	// properties
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	// constructor
	public UsersDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	// Selects all users from database returns List 
	@Override
	public List<RegisterModel> findAll() {
		String sql = "SELECT * FROM users";
		List<RegisterModel> users = new ArrayList<RegisterModel>();

		try {
			// Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next()) {
				users.add(new RegisterModel(srs.getInt("userId"),
											srs.getString("firstName"),
											srs.getString("lastName"),
											srs.getString("email"),
											srs.getString("phoneNumber"),
											new LoginModel(srs.getString("userName"), 
													srs.getString("password"))));
			}
		} catch (Exception c) {
			c.printStackTrace();
		}

		return users;
	}

	/*
	 * Finds user by Id
	 */
	@Override
	public RegisterModel findById(int id) {

		//Creates new user
		RegisterModel newUser = null;
		
		//Sets the SQL
		String sql = "SELECT * FROM users";
		
		//Makes a list of users
		List<RegisterModel> users = new ArrayList<RegisterModel>();
		try {
			
			//Sets the sqlrowset
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			
			//Creates the list contents
			while (srs.next()) {
				users.add(new RegisterModel(srs.getInt("userId"),
											srs.getString("firstName"),
											srs.getString("lastName"),
											srs.getString("email"),
											srs.getString("phoneNumber"),
											new LoginModel(srs.getString("userName"), 
													srs.getString("password"))));
			}
			
			//Checks for the id through the list
			for(RegisterModel var : users) {
				if(var.getUserId()==id) {
					
					//Sets new user
					newUser = var;
					break;
				}
			}
			if(newUser != null) {
				return newUser;
			}
			else {
				RegisterModel emptyUser = new RegisterModel();
				return emptyUser;
			}
		}
		
		
		catch(Exception ex) {
			return null;
		}
		
		//Returns new user
		
	
	}

	/*
	 * Insert values to databse creating new user
	 */
	@Override
	public int create(RegisterModel t) {
		try {
			String sql = "INSERT INTO users(firstName, lastName, email, phoneNumber, userName, password) VALUES(?, ?, ?, ?, ?, ?)";

			int rows = jdbcTemplateObject.update(sql,
											t.getFirstName(),
											t.getLastName(),
											t.getEmail(),
											t.getPhone(),
											t.getCredentials().getUsername(),
											t.getCredentials().getPassword());

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
	public int update(RegisterModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(RegisterModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
