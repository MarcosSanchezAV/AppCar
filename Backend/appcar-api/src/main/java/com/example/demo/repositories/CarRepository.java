package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Car;

public interface CarRepository  {
	List<Car> getCars();
	
	List<Car> getCars(boolean ascendent);
	
	List<Car> getCars(String type);
	
	List<Car> getCars(boolean ascendent, String type);
	
	Optional<Car> getCar(Long id);
	
	void setAvailable(boolean available, Long id);
}
