package com.gcu.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterModel {
	private int userId;
	//Data Validation
    @NotNull(message="First name is a required field")
    @Size(min=2, max=45, message="First name must be between 2 and 45 characters")
    private String firstName;
    
    //Data Validation
    @NotNull(message="Last name is a required field")
    @Size(min=2, max=45, message="Last name must be between 2 and 45 characters")
    private String lastName;
    
    //Data Validation
    @NotNull(message="Email is a required field")
    @Size(min=5, max=45, message="Email must be between 5 and 45 characters")
    private String email;
    
    //Data Validation
    @NotNull(message="Phone Number is a required field")
    @Size(min=5, max=45, message="Phone Number must be between 5 and 45 characters")
    private String phone;
    
    //Data Validation
    //Makes the username and password its own variable
    @Valid
    private LoginModel credentials;

    //Constructor
	public RegisterModel(int userId, String firstName, String lastName, String email, String phone, LoginModel credentials) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.credentials = credentials;
	}
    //Constructor
	public RegisterModel() {
		super();
		this.userId = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phone = "";
		this.credentials = new LoginModel();
	}

	// auto generated getters and setters for username and password

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LoginModel getCredentials() {
		return credentials;
	}

	public void setCredentials(LoginModel credentials) {
		this.credentials = credentials;
	}
}