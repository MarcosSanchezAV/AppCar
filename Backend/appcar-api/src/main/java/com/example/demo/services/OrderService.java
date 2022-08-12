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

import com.example.demo.DAO.OrderDAO;
import com.example.demo.models.Order;
import com.example.demo.queries.OrderQueries;

@Component
public class OrderService implements OrderDAO {

	private static final Logger log = LoggerFactory.getLogger(CarService.class);
	private JdbcTemplate jdcbTemplate;
	
	public OrderService(JdbcTemplate jdcbTemplate) {
		this.jdcbTemplate = jdcbTemplate;
	}
	
	@Override
	public Order createOrder(Order order) {
		
		jdcbTemplate.update(OrderQueries.createOrder, order.getIdCar(), order.getDateStart(), LocalDate.parse(order.getDateStart()).plusDays(order.getDays()).toString(), order.isDelivered(), order.getDays(), order.getAmount(), order.getNameUser(), order.getEmailUser());
		return order;
	}
	
	RowMapper<Order> rowMapper = (rs, rowNum) -> {
		Order order = new Order();
		order.setId(rs.getLong("id"));
		order.setIdCar(rs.getLong("id_car"));
		order.setDateStart(rs.getString("date_start"));
		order.setDateEnd(rs.getString("date_end"));
		order.setDelivered(rs.getBoolean("delivered"));
		order.setDays(rs.getInt("days"));
		order.setAmount(rs.getDouble("amount"));
		order.setNameUser(rs.getString("name_user"));
		order.setEmailUser(rs.getString("email_user"));
		return order;
	};

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Order> getOrder(Long id, String email) {
		Order order = null;
		try {
			order = jdcbTemplate.queryForObject(OrderQueries.OrderIdEmail, new Object[] {id, email}, rowMapper);
		} catch (DataAccessException ex) {
			log.info("Order not found");
		}
		return Optional.ofNullable(order);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public Optional<Order> getOrder(String email) {
		Order order = null;
		try {
			order = jdcbTemplate.queryForObject(OrderQueries.OrderEmail, new Object[] { email}, rowMapper);
		} catch (DataAccessException ex) {
			log.info("Order not found");
		}
		return Optional.ofNullable(order);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Order> getOrder(Long id) {
		Order order = null;
		try {
			order = jdcbTemplate.queryForObject(OrderQueries.OrderId, new Object[] {id}, rowMapper);
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
		jdcbTemplate.update(OrderQueries.setDelivered, delivered, id);
	}




}
