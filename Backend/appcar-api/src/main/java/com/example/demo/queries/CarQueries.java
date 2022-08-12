package com.example.demo.queries;

public class CarQueries {
	public static final String allCars = "SELECT * FROM cars WHERE available = true";
	
	public static final String CarsAsc = "SELECT * FROM cars WHERE available = true ORDER BY price ASC";
	
	public static final String CarsDesc = "SELECT * FROM cars WHERE available = true ORDER BY price DESC";
	
	public static final String CarsType = "SELECT * FROM cars WHERE available = true AND type_car = ?";
	
	public static final String CarId = "SELECT * FROM cars WHERE id = ?";
	
	public static final String CarsTypeAsc = "SELECT * FROM cars WHERE available = true AND type_car = ? ORDER BY price ASC";
	
	public static final String CarsTypeDesc = "SELECT * FROM cars WHERE available = true AND type_car = ? ORDER BY price DESC";
	
	public static final String setAvailable = "UPDATE cars SET available = ? WHERE id = ?";
	
}
