package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
	
	@Id
	private Long id;
	
	private String name_car;
	
	private double price;
	
	private String img;
	
	private String type_car;
	
	private boolean available;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_car() {
		return name_car;
	}

	public void setName_car(String name_car) {
		this.name_car = name_car;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getType_car() {
		return type_car;
	}

	public void setType_car(String type_car) {
		this.type_car = type_car;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Car(Long id, String name_car, double price, String img, String type_car, boolean available) {
		super();
		this.id = id;
		this.name_car = name_car;
		this.price = price;
		this.img = img;
		this.type_car = type_car;
		this.available = available;
	}
	
	public Car() {
		
	}


}
