package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TruckModel {

	// Creates variables
	private int truckId;

	@NotNull(message = "Truck Company is a required field")
	private String truckCompany;

	@NotNull(message = "Truck Number is a required field")
	private String truckNumber;

	public TruckModel() {
		this.truckId = 0;
		this.truckNumber = "";
		this.truckCompany = "";
	}

	public TruckModel(int truckId,
			@NotNull(message = "Truck Company is a required field") String truckCompany,
			@NotNull(message = "Truck Number is a required field") String truckNumber) {
		this.truckId = truckId;
		this.truckCompany = truckCompany;
		this.truckNumber = truckNumber;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String getTruckCompany() {
		return truckCompany;
	}

	public void setTruckCompany(String truckCompany) {
		this.truckCompany = truckCompany;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

}
