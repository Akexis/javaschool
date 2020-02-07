package com.alexisprojects.users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
	private UserRepository userRepo;
	
	//TODO add in user type
	public UserEntity getUser(UUID id) {
		List<UserEntity> users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		return users.stream().filter(u -> u.getId() == id).findFirst().get();
	}
	
	public List<UserEntity> getAllUsers(){
		List<UserEntity> users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		return users;
	}
}
