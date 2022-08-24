package com.example.demo.queries;

public class CarQueries {
	public static final String ALL_CARS = "SELECT cars.id, cars.name_car, cars.price, cars.img, cars.type_car, orders.date_start, orders.date_end FROM cars LEFT JOIN orders ON cars.id = orders.id_car AND orders.delivered = false";
	
	public static final String CARS_ASC = "SELECT cars.id, cars.name_car, cars.price, cars.img, cars.type_car, orders.date_start, orders.date_end FROM cars LEFT JOIN orders ON cars.id = orders.id_car AND orders.delivered = false ORDER BY price ASC";
	
	public static final String CARS_DESC = "SELECT cars.id, cars.name_car, cars.price, cars.img, cars.type_car, orders.date_start, orders.date_end FROM cars LEFT JOIN orders ON cars.id = orders.id_car AND orders.delivered = false ORDER BY price DESC";
	
	public static final String CARS_TYPE = "SELECT cars.id, cars.name_car, cars.price, cars.img, cars.type_car, orders.date_start, orders.date_end FROM cars LEFT JOIN orders ON cars.id = orders.id_car AND orders.delivered = false WHERE type_car = ?";
	
	public static final String CAR_ID = "SELECT * FROM cars WHERE id = ?";
	
	public static final String CARS_TYPE_ASC = "SELECT cars.id, cars.name_car, cars.price, cars.img, cars.type_car, orders.date_start, orders.date_end FROM cars LEFT JOIN orders ON cars.id = orders.id_car AND orders.delivered = false WHERE type_car = ? ORDER BY price ASC";
	
	public static final String CARS_TYPE_DESC = "SELECT cars.id, cars.name_car, cars.price, cars.img, cars.type_car, orders.date_start, orders.date_end FROM cars LEFT JOIN orders ON cars.id = orders.id_car AND orders.delivered = false WHERE type_car = ? ORDER BY price DESC";
	
	public static final String SET_AVAILABLE = "UPDATE cars SET available = ? WHERE id = ?";
	
}
