package com.alexisprojects.users;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "address")
@Component
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	@Column(name="street")
	private String street;
	@Column(name="city")
	private String city;
	@Column(name="usstate")
	private UUID usstate;
	@Column(name="zipcode")
	private String zipcode;
	@Column(name="isprimary")
	private boolean isPrime;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public UUID getState() {
		return usstate;
	}
	public void setState(UUID usstate) {
		this.usstate = usstate;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public boolean isPrimary() {
		return isPrime;
	}
	public void setPrimary(boolean primary) {
		this.isPrime = primary;
	}
	
	
}
