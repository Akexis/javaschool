package com.alexisprojects.users;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "email")
@Component
public class Email {
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	@Column(name="email")
	private String email;
	@Column(name="isprimary")
	private boolean isPrime;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPrimary() {
		return isPrime;
	}
	public void setPrimary(boolean primary) {
		this.isPrime = primary;
	}
}
