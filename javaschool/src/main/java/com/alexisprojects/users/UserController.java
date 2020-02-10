package com.alexisprojects.users;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	
	//Single User Mapping
	@RequestMapping("/students/{id}")
	public UserEntity getStudent(@PathVariable UUID id) {
		return userService.getUser(id);
	}
	@RequestMapping("/teachers/{id}")
	public UserEntity getTeacher(@PathVariable UUID id) {
		return userService.getUser(id);
	}
	@RequestMapping("/admin/{id}")
	public UserEntity getAdmin(@PathVariable UUID id) {
		return userService.getUser(id);
	}
	
	@RequestMapping("/users")
	public List<UserEntity> getAllUsers(){
		return userService.getAllUsers("Users");
	}
	
	//Multiple Users Mapping
	@RequestMapping("/students")
	public List<UserEntity> getAllStudents(){
		return userService.getAllUsers("Student");
	}
	@RequestMapping("/teachers")
	public List<UserEntity> getAllTeachers(){
		return userService.getAllUsers("Teacher");
	}
	@RequestMapping("/admin")
	public List<UserEntity> getAllAdmin(){
		return userService.getAllUsers("Admin");
	}
	
	@RequestMapping("/pending")
	public List<UserEntity> getAllPending(){
		return userService.getPending();
	}

}
