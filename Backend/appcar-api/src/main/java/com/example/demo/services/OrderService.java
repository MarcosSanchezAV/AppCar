package com.example.demo.services;

import java.time.LocalDate;
// import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.models.Order;
import com.example.demo.repositories.OrderRepository;

@Component
public class OrderService implements OrderRepository {

	private static final Logger log = LoggerFactory.getLogger(CarService.class);
	private JdbcTemplate jdcbTemplate;
	
	public OrderService(JdbcTemplate jdcbTemplate) {
		this.jdcbTemplate = jdcbTemplate;
	}
	
	@Override
	public Order createOrder(Order order) {
		String sql = "INSERT INTO orders (id_car, date_start, date_end, delivered, days, amount, name_user, email_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		jdcbTemplate.update(sql, order.getId_car(), order.getDate_start(), LocalDate.parse(order.getDate_start()).plusDays(order.getDays()).toString(), order.isDelivered(), order.getDays(), order.getAmount(), order.getName_user(), order.getEmail_user());
		return order;
	}
	
	RowMapper<Order> rowMapper = (rs, rowNum) -> {
		Order order = new Order();
		order.setId(rs.getLong("id"));
		order.setId_car(rs.getLong("id_car"));
		order.setDate_start(rs.getString("date_start"));
		order.setDate_end(rs.getString("date_end"));
		order.setDelivered(rs.getBoolean("delivered"));
		order.setDays(rs.getInt("days"));
		order.setAmount(rs.getDouble("amount"));
		order.setName_user(rs.getString("name_user"));
		order.setEmail_user(rs.getString("email_user"));
		return order;
	};

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Order> getOrder(Long id, String email) {
		String sql = "SELECT * FROM orders WHERE id = ? AND email_user = ?";
		Order order = null;
		try {
			order = jdcbTemplate.queryForObject(sql, new Object[] {id, email}, rowMapper);
		} catch (DataAccessException ex) {
			log.info("Order not found");
		}
		return Optional.ofNullable(order);
	}

	
	
	@SuppressWarnings("deprecation")
	@Override
	public Optional<Order> getOrder(String email) {
		String sql = "SELECT * FROM orders WHERE delivered = false AND email_user = ?";
		Order order = null;
		try {
			order = jdcbTemplate.queryForObject(sql, new Object[] { email}, rowMapper);
		} catch (DataAccessException ex) {
			log.info("Order not found");
		}
		return Optional.ofNullable(order);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Order> getOrder(Long id) {
		String sql = "SELECT * FROM orders WHERE id = ?";
		Order order = null;
		try {
			order = jdcbTemplate.queryForObject(sql, new Object[] {id}, rowMapper);
		} catch (DataAccessException ex) {
			log.info("Order not found");
		}
		return Optional.ofNullable(order);
	}

	@Override
	public boolean isCaducated(String end) {
		LocalDate endtime = LocalDate.parse(end);
		return endtime.isBefore(LocalDate.now()) || endtime.isEqual(LocalDate.now());
	}

	@Override
	public void setDelivered(boolean delivered, Long id) {
		String sql = "UPDATE orders SET delivered = ? WHERE id = ?";
		jdcbTemplate.update(sql, delivered, id);
	}




}
