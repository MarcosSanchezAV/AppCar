package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;

@Component
public class CarService implements CarRepository {
	
	private static final Logger log = LoggerFactory.getLogger(CarService.class);
	private JdbcTemplate jdcbTemplate;
	
	public CarService(JdbcTemplate jdcbTemplate) {
		this.jdcbTemplate = jdcbTemplate;
	}
	
	RowMapper<Car> rowMapper = (rs, rowNum) -> {
		Car car = new Car();
		car.setId(rs.getLong("id"));
		car.setName_car(rs.getString("name_car"));
		car.setPrice(rs.getDouble("price"));
		car.setImg(rs.getString("img"));
		car.setType_car(rs.getString("type_car"));
		car.setAvailable(true);
		return car;
	};
	
	@Override
	public List<Car> getCars() {
		
		String sql = "SELECT * FROM cars WHERE available = true";
		
		return jdcbTemplate.query(sql, rowMapper);
		
	}

	@Override
	public List<Car> getCars(boolean ascendent) {
		String sql = "SELECT * FROM cars WHERE available = true ORDER BY price ";
		if (ascendent) {
			sql += "ASC";
		} else {
			sql += "DESC";
		}
		
		return jdcbTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Car> getCars(String type) {
		String sql = "SELECT * FROM cars WHERE available = true AND type_car = ?";
		
		return jdcbTemplate.query(sql, rowMapper, type);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Car> getCar(Long id) {
		String sql = "SELECT * FROM cars WHERE id = ?";
		Car car = null;
		try {
			car = jdcbTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
		} catch (DataAccessException ex) {
			log.info("Car not found");
		}
		return Optional.ofNullable(car);
	}

	@Override
	public List<Car> getCars(boolean ascendent, String type) {
		String sql = "SELECT * FROM cars WHERE available = true AND type_car = ? ORDER BY price ";
		if (ascendent) {
			sql += "ASC";
		} else {
			sql += "DESC";
		}
		return jdcbTemplate.query(sql, rowMapper, type);
	}

	@Override
	public void setAvailable(boolean available, Long id) {
		String sql = "UPDATE cars SET available = ? WHERE id = ?";
		jdcbTemplate.update(sql, available, id);
	}
	
}
