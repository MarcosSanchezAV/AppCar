package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.DaoImpl.OrderDaoImpl;
import com.example.demo.models.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	OrderDaoImpl orderDaoImpl;
	
	@PostMapping()
	public Order createOrder(@RequestBody Order order) {
		return orderDaoImpl.createOrder(order);
	}
	
	@GetMapping()
	public Optional<Order> getOrder(@RequestParam Long id, @RequestParam String email) {
		return orderDaoImpl.getOrder(id, email);
	}
	
	@GetMapping("/order")
	public Optional<Order> getOrder(@RequestParam String email) {
		return orderDaoImpl.getOrder(email);
	}
	
	@GetMapping("/caducated")
	public boolean isCaducated(@RequestParam String end) {
		return orderDaoImpl.isCaducated(end);
	}
	
	@GetMapping("/id")
	public Optional<Order> getOrder(@RequestParam Long id) {
		return orderDaoImpl.getOrder(id);
	}
	
	@PostMapping("/delivered")
	public void setDelivered(@RequestParam boolean delivered, @RequestParam Long id) {
		orderDaoImpl.setDelivered(delivered, id);
	}
	
	@GetMapping("/checkDates")
	public int checkDates(@RequestParam String dateStart, @RequestParam String dateEnd) {
		return orderDaoImpl.checkDates(dateStart, dateEnd);
	}
	
	@GetMapping("/checkDate")
	public boolean checkDate(@RequestParam String dateStart) {
		return orderDaoImpl.checkDate(dateStart);
	}
	
}
