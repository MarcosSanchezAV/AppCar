package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
@SecondaryTable(name = "orders")
public class Car {
	
	@Id
	private Long id;
	
	@Column(name = "name_car")
	private String nameCar;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "type_car")
	private String typeCar;
	
	@Column(name = "available")
	private boolean available;
	
	@Column(name = "date_start", table = "orders")
	private String dateStart;
	
	@Column(name = "date_end", table = "orders")
	private String dateEnd;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCar() {
		return nameCar;
	}

	public void setNameCar(String nameCar) {
		this.nameCar = nameCar;
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

	public String getTypeCar() {
		return typeCar;
	}

	public void setTypeCar(String typeCar) {
		this.typeCar = typeCar;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Car(Long id, String nameCar, double price, String img, String typeCar, boolean available) {
		super();
		this.id = id;
		this.nameCar = nameCar;
		this.price = price;
		this.img = img;
		this.typeCar = typeCar;
		this.available = available;
	}
	
	public Car() {
		
	}
	
	

	public Car(Long id, String nameCar, double price, String img, String typeCar, boolean available, String startDate,
			String endDate) {
		super();
		this.id = id;
		this.nameCar = nameCar;
		this.price = price;
		this.img = img;
		this.typeCar = typeCar;
		this.available = available;
		this.dateStart = startDate;
		this.dateEnd = endDate;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String startDate) {
		this.dateStart = startDate;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String endDate) {
		this.dateEnd = endDate;
	}


}
