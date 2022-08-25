package com.example.demo.Dao.DaoImpl;

import java.time.LocalDate;
// import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.OrderDao;
import com.example.demo.models.Order;
import com.example.demo.queries.OrderQueries;

@Component
public class OrderDaoImpl implements OrderDao {

	private static final Logger log = LoggerFactory.getLogger(CarDaoImpl.class);
	private JdbcTemplate jdcbTemplate;
	
	public OrderDaoImpl(JdbcTemplate jdcbTemplate) {
		this.jdcbTemplate = jdcbTemplate;
	}
	
	@Override
	public Order createOrder(Order order) {
		
		jdcbTemplate.update(OrderQueries.CREATE_ORDER, order.getIdCar(), order.getDateStart(), LocalDate.parse(order.getDateStart()).plusDays(order.getDays()).toString(), order.isDelivered(), order.getDays(), order.getAmount(), order.getNameUser(), order.getEmailUser());
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
			order = jdcbTemplate.queryForObject(OrderQueries.ORDER_ID_EMAIL, new Object[] {id, email}, rowMapper);
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
			order = jdcbTemplate.queryForObject(OrderQueries.ORDER_EMAIL, new Object[] { email}, rowMapper);
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
			order = jdcbTemplate.queryForObject(OrderQueries.ORDER_ID, new Object[] {id}, rowMapper);
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
		jdcbTemplate.update(OrderQueries.SET_DELIVERED, delivered, id);
	}

	@Override
	public int checkDates(String dateStart, String dateEnd) {
		LocalDate start = LocalDate.parse(dateStart);
		LocalDate end = LocalDate.parse(dateEnd);
		if (start.isAfter(end) || start.isEqual(end)) {
			return 1;
		} else if (start.isBefore(LocalDate.now())) {
			return 2;
		} else {
			return 3;
		}
	}

	@Override
	public boolean checkDate(String dateStart) {
		LocalDate start = LocalDate.parse(dateStart);
		return !start.isBefore(LocalDate.now());
	}




}
