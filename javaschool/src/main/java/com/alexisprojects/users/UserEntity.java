package com.alexisprojects.users;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Component
public abstract class UserEntity {
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	// If the profilePic is empty, set it to a default.
	@Column(name="profilepic")
	private String profilePic;
	// Maybe temporary. Might actually put in password stuff.
	@Column(name="password")
	private String password;
	@Column(name="role")
	private UUID role;
	@Column(name="bio")
	private String bio;
	// Needs to be auto-generated
	@Column(name="registered")
	private LocalDateTime registered;
	// Default should be false
	@Column(name="approved")
	private boolean approved;
	
	@Transient
	private List<Email> emails;
	@Transient
	private List<Phone> phoneNums;
	@Transient
	private List<Address> addresses;
	
	public UserEntity() {}
	
	public UserEntity(String fn, String ln, String pic, String pw, UUID role, String bio, List<Email> emails, List<Phone> nums, List<Address> addresses) {
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
	public UUID getRole() {
		return role;
	}
	public void setRole(UUID role) {
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
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	public List<Phone> getPhoneNums() {
		return phoneNums;
	}
	public void setPhoneNums(List<Phone> phoneNums) {
		this.phoneNums = phoneNums;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
