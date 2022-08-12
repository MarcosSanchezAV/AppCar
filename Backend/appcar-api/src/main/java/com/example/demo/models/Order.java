package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
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

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
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

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	@Column(name = "id_car")
	private Long idCar;
	
	@Column(name = "date_start")
	private String dateStart = LocalDate.now().toString();
	
	@Column(name = "date_end")
	private String dateEnd = LocalDate.now().plusDays(this.days).toString();;
	
	private boolean delivered = false;
	
	private int days;
	
	private double amount;
	
	@Column(name = "name_user")
	private String nameUser;
	
	@Column(name = "email_user")
	private String emailUser;

	public Order(Long id, Long idCar, String dateStart, String dateEnd, boolean delivered, int days, double amount,
			String nameUser, String emailUser) {
		this.id = id;
		this.idCar = idCar;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.delivered = delivered;
		this.days = days;
		this.amount = amount;
		this.nameUser = nameUser;
		this.emailUser = emailUser;
	}
	
	public Order() {
		
	}

	public Order(Long idCar, int days, double amount, String nameUser, String emailUser) {
		this.idCar = idCar;
		this.dateEnd = LocalDate.now().plusDays(days).toString();
		this.days = days;
		this.amount = amount;
		this.nameUser = nameUser;
		this.emailUser = emailUser;
	}
	
	
}
