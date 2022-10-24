package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {
	
	//Data Validation
	@NotNull(message="User name is a required field")
	@Size(min=1, max=32, message="User name must be between 1 and 32 characters")
	private String username;
	//Data Validation
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	
	
	//makes a login model
	public LoginModel(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}
	//default constructor
	public LoginModel() 
	{
		super();
		this.password = "";
		this.username = "";
	}
	
	// auto generated getters and setters for username and password
	
	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

}
