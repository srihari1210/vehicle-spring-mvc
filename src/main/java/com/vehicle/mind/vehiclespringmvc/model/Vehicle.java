package com.vehicle.mind.vehiclespringmvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Vehicle {


	@Id
	private String number;
	@NotBlank
	private String name;
	
	private String type;
	
	private String model;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	 

	public Vehicle() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Vehicle(String number, @NotBlank String name, String type, String model) {
		super();
		this.number = number;
		this.name = name;
		this.type = type;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Vehicle [number=" + number + ", name=" + name + ", type=" + type + ", model=" + model + "]";
	}

	 

}
