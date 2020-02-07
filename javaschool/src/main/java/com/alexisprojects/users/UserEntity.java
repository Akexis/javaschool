package com.alexisprojects.users;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "users")
@Component
public abstract class UserEntity {
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	private String firstName;
	private String lastName;
	// If the profilePic is empty, set it to a default.
	private String profilePic;
	// Maybe temporary. Might actually put in password stuff.
	private String password;
	private String role;
	private String bio;
	// Needs to be auto-generated
	private LocalDateTime registered;
	// Default should be false
	private boolean approved;
	
	private List emails;
	private List phoneNums;
	private List addresses;
	
	public UserEntity() {}
	
	public UserEntity(String fn, String ln, String pic, String pw, String role, String bio, List emails, List nums, List addresses) {
		this.firstName = fn;
		this.lastName = ln;
		this.profilePic = pic;
		this.password = pw;
		this.role = role;
		this.bio = bio;
		this.emails = emails;
		this.phoneNums = nums;
		this.addresses = addresses;
	}
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public LocalDateTime getRegistered() {
		return registered;
	}
	public void setRegistered(LocalDateTime registered) {
		this.registered = registered;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public List getEmails() {
		return emails;
	}
	public void setEmails(List emails) {
		this.emails = emails;
	}
	public List getPhoneNums() {
		return phoneNums;
	}
	public void setPhoneNums(List phoneNums) {
		this.phoneNums = phoneNums;
	}
	public List getAddresses() {
		return addresses;
	}
	public void setAddresses(List addresses) {
		this.addresses = addresses;
	}
	
}
