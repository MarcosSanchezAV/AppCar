package com.example.demo.queries;

public class OrderQueries {
	
	public static final String createOrder = "INSERT INTO orders (id_car, date_start, date_end, delivered, days, amount, name_user, email_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String OrderIdEmail = "SELECT * FROM orders WHERE id = ? AND email_user = ?";
	
	public static final String OrderEmail = "SELECT * FROM orders WHERE delivered = false AND email_user = ?";
	
	public static final String OrderId = "SELECT * FROM orders WHERE id = ?";
	
	public static final String setDelivered = "UPDATE orders SET delivered = ? WHERE id = ?";

}
