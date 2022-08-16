package com.example.demo.queries;

public class OrderQueries {
	
	public static final String CREATE_ORDER = "INSERT INTO orders (id_car, date_start, date_end, delivered, days, amount, name_user, email_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String ORDER_ID_EMAIL = "SELECT * FROM orders WHERE id = ? AND email_user = ?";
	
	public static final String ORDER_EMAIL = "SELECT * FROM orders WHERE delivered = false AND email_user = ?";
	
	public static final String ORDER_ID = "SELECT * FROM orders WHERE id = ?";
	
	public static final String SET_DELIVERED = "UPDATE orders SET delivered = ? WHERE id = ?";

}
