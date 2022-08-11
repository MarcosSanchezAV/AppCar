package com.example.demo.repositories;

// import java.util.List;
import java.util.Optional;

import com.example.demo.models.Order;

public interface OrderRepository {
	
	Order createOrder(Order order);
	
	// List<Order> getOrders();
	
	Optional<Order> getOrder(Long id, String email);
	
	boolean isCaducated(String end);
	
	Optional<Order> getOrder(String email);
	
	Optional<Order> getOrder(Long id);
	
	void setDelivered(boolean delivered, Long id);
}
