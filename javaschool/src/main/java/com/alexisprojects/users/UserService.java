package com.alexisprojects.users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	
	public UserEntity getUser(UUID id) {
		List<UserEntity> users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		return users.stream().filter(u -> u.getId() == id).findFirst().get();
	}
	
	public List<UserEntity> getAllUsers(String r){
		if(r != "Users") {
			List<UserEntity> users = new ArrayList<>();
			List<UserEntity> filtered = new ArrayList<>();
			List<RoleEntity> roles = new ArrayList<>();
			userRepo.findAll().forEach(users::add);
			roleRepo.findAll().forEach(roles::add);
			RoleEntity findByRole = new RoleEntity();
			
			findByRole = roles.stream().filter(rl -> rl.getRole() == r).findFirst().get();
			
			for(UserEntity user : users) {
				if(findByRole.getRole() == r) {
					filtered.add(user);
				}
			}
			return filtered;
		}else {
			List<UserEntity> users = new ArrayList<>();
			userRepo.findAll().forEach(users::add);
			return users;
		}
		
	}
	
	public List<UserEntity> getPending(){
		List<UserEntity> users = new ArrayList<>();
		List<UserEntity> filtered = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		for(UserEntity user : users) {
			if(user.isApproved() == true) {
				filtered.add(user);
			}
		}
		return filtered;
	}
}
