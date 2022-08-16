package com.example.demo.queries;

public class CarQueries {
	public static final String ALL_CARS = "SELECT * FROM cars WHERE available = true";
	
	public static final String CARS_ASC = "SELECT * FROM cars WHERE available = true ORDER BY price ASC";
	
	public static final String CARS_DESC = "SELECT * FROM cars WHERE available = true ORDER BY price DESC";
	
	public static final String CARS_TYPE = "SELECT * FROM cars WHERE available = true AND type_car = ?";
	
	public static final String CAR_ID = "SELECT * FROM cars WHERE id = ?";
	
	public static final String CARS_TYPE_ASC = "SELECT * FROM cars WHERE available = true AND type_car = ? ORDER BY price ASC";
	
	public static final String CARS_TYPE_DESC = "SELECT * FROM cars WHERE available = true AND type_car = ? ORDER BY price DESC";
	
	public static final String SET_AVAILABLE = "UPDATE cars SET available = ? WHERE id = ?";
	
}
