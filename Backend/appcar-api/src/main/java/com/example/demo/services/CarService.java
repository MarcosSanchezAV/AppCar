package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.DAO.CarDAO;
import com.example.demo.models.Car;
import com.example.demo.queries.CarQueries;

@Component
public class CarService implements CarDAO {
	
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
		
		return jdcbTemplate.query(CarQueries.allCars, rowMapper);
		
	}

	@Override
	public List<Car> getCars(boolean ascendent) {
		
		if (ascendent) {
			return jdcbTemplate.query(CarQueries.CarsAsc, rowMapper);
		} else {
			return jdcbTemplate.query(CarQueries.CarsDesc, rowMapper);
		}
		
	}

	@Override
	public List<Car> getCars(String type) {
		
		return jdcbTemplate.query(CarQueries.CarsType, rowMapper, type);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Car> getCar(Long id) {
		Car car = null;
		try {
			car = jdcbTemplate.queryForObject(CarQueries.CarId, new Object[]{id}, rowMapper);
		} catch (DataAccessException ex) {
			log.info("Car not found");
		}
		return Optional.ofNullable(car);
	}

	@Override
	public List<Car> getCars(boolean ascendent, String type) {
		if (ascendent) {
			return jdcbTemplate.query(CarQueries.CarsTypeAsc, rowMapper, type);
		} else {
			return jdcbTemplate.query(CarQueries.CarsTypeDesc, rowMapper, type);
		}
	}

	@Override
	public void setAvailable(boolean available, Long id) {
		jdcbTemplate.update(CarQueries.setAvailable, available, id);
	}
	
}
