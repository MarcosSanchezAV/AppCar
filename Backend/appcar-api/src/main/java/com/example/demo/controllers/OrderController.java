package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Order;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping()
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@GetMapping()
	public Optional<Order> getOrder(@RequestParam Long id, @RequestParam String email) {
		return orderService.getOrder(id, email);
	}
	
	@GetMapping("/order")
	public Optional<Order> getOrder(@RequestParam String email) {
		return orderService.getOrder(email);
	}
	
	@GetMapping("/caducated")
	public boolean isCaducated(@RequestParam String end) {
		return orderService.isCaducated(end);
	}
	
	@GetMapping("/id")
	public Optional<Order> getOrder(@RequestParam Long id) {
		return orderService.getOrder(id);
	}
	
	@PostMapping("/delivered")
	public void setDelivered(@RequestParam boolean delivered, @RequestParam Long id) {
		orderService.setDelivered(delivered, id);
	}
	
}
