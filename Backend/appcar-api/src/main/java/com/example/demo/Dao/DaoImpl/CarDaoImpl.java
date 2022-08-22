package com.example.demo.Dao.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.CarDao;
import com.example.demo.models.Car;
import com.example.demo.queries.CarQueries;

@Component
public class CarDaoImpl implements CarDao {
	
	private static final Logger log = LoggerFactory.getLogger(CarDaoImpl.class);
	private JdbcTemplate jdcbTemplate;
	
	public CarDaoImpl(JdbcTemplate jdcbTemplate) {
		this.jdcbTemplate = jdcbTemplate;
	}
	
	RowMapper<Car> rowMapper = (rs, rowNum) -> {
		Car car = new Car();
		car.setId(rs.getLong("cars.id"));
		car.setNameCar(rs.getString("name_car"));
		car.setPrice(rs.getDouble("price"));
		car.setImg(rs.getString("img"));
		car.setTypeCar(rs.getString("type_car"));
		car.setAvailable(true);
		car.setDateStart(rs.getString("orders.date_start"));
		car.setDateEnd(rs.getString("orders.date_end"));
		return car;
	};
	
	RowMapper<Car> rowMapperId = (rs, rowNum) -> {
		Car car = new Car();
		car.setId(rs.getLong("id"));
		car.setNameCar(rs.getString("name_car"));
		car.setPrice(rs.getDouble("price"));
		car.setImg(rs.getString("img"));
		car.setTypeCar(rs.getString("type_car"));
		car.setAvailable(true);
		return car;
	};
	@Override
	public List<Car> getCars() {
		
		return jdcbTemplate.query(CarQueries.ALL_CARS, rowMapper);
		
	}

	@Override
	public List<Car> getCars(boolean ascendent) {
		
		if (ascendent) {
			return jdcbTemplate.query(CarQueries.CARS_ASC, rowMapper);
		} else {
			return jdcbTemplate.query(CarQueries.CARS_DESC, rowMapper);
		}
		
	}

	@Override
	public List<Car> getCars(String type) {
		
		return jdcbTemplate.query(CarQueries.CARS_TYPE, rowMapper, type);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Car> getCar(Long id) {
		Car car = null;
		try {
			car = jdcbTemplate.queryForObject(CarQueries.CAR_ID, new Object[]{id}, rowMapperId);
		} catch (DataAccessException ex) {
			log.info("Car not found");
		}
		return Optional.ofNullable(car);
	}

	@Override
	public List<Car> getCars(boolean ascendent, String type) {
		if (ascendent) {
			return jdcbTemplate.query(CarQueries.CARS_TYPE_ASC, rowMapper, type);
		} else {
			return jdcbTemplate.query(CarQueries.CARS_TYPE_DESC, rowMapper, type);
		}
	}

	@Override
	public void setAvailable(boolean available, Long id) {
		jdcbTemplate.update(CarQueries.SET_AVAILABLE, available, id);
	}
	
}
