package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.DaoImpl.CarDaoImpl;
import com.example.demo.models.Car;

@RestController
@RequestMapping("/api/cars")
public class CarController {

	@Autowired
	CarDaoImpl carDaoImpl;
	
	@GetMapping()
	public ArrayList<Car> getCars() {
		return (ArrayList<Car>) carDaoImpl.getCars();
	}
	
	@GetMapping("/ascendent")
	public ArrayList<Car> getCars(@RequestParam boolean ascendent) {
		return (ArrayList<Car>) carDaoImpl.getCars(ascendent);
	}
	
	@GetMapping("/type")
	public ArrayList<Car> getCars(@RequestParam String type) {
		return (ArrayList<Car>) carDaoImpl.getCars(type);
	}
	
	@GetMapping("/ascendent/type")
	public ArrayList<Car> getCars(@RequestParam boolean ascendent, @RequestParam String type) {
		return (ArrayList<Car>) carDaoImpl.getCars(ascendent, type);
	}
	
	@GetMapping("/id")
	public Optional<Car> getCar(@RequestParam Long id) {
		return carDaoImpl.getCar(id);
	}
	
	@PostMapping("/available")
	public void setAvailable(@RequestParam boolean available, @RequestParam Long id) {
		carDaoImpl.setAvailable(available, id);
	}
}
