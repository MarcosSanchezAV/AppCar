package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_car() {
		return id_car;
	}

	public void setId_car(Long id_car) {
		this.id_car = id_car;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	private Long id_car;
	
	private String date_start = LocalDate.now().toString();
	
	private String date_end = LocalDate.now().plusDays(this.days).toString();;
	
	private boolean delivered = false;
	
	private int days;
	
	private double amount;
	
	private String name_user;
	
	private String email_user;

	public Order(Long id, Long id_car, String date_start, String date_end, boolean delivered, int days, double amount,
			String name_user, String email_user) {
		this.id = id;
		this.id_car = id_car;
		this.date_start = date_start;
		this.date_end = date_end;
		this.delivered = delivered;
		this.days = days;
		this.amount = amount;
		this.name_user = name_user;
		this.email_user = email_user;
	}
	
	public Order() {
		
	}

	public Order(Long id_car, int days, double amount, String name_user, String email_user) {
		this.id_car = id_car;
		this.date_end = LocalDate.now().plusDays(days).toString();
		this.days = days;
		this.amount = amount;
		this.name_user = name_user;
		this.email_user = email_user;
	}
	
	
}
