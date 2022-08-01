package com.docker.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.entity.User;
import com.docker.userserviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController 
{	
	@Autowired
	private  UserServiceImpl userService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping
	public User saveUser(@Valid @RequestBody User user)
	{
		log.info("Rest API To Save User {} ", user);
		return userService.saveUser(user);
	}

	@PutMapping
	public User updateUser(@Valid @RequestBody User user)
	{
		log.info("Rest API To Update User {} ", user);
		
		return userService.updateUser(user);
	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id)
	{
		log.info("Rest Api To Get User By Id {} ", id);
		return userService.getUserById(id);
	}

	@GetMapping
	public List<User> getAllUsers()
	{
		log.info("Rest Api To Get All Users");
		//https://resp.app/
		//https://www.electronjs.org/apps/anotherredisdesktopmanager
		return userService.getAllUsers();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) 
	{
		log.info("Rest Api To Delete User By Id {} ", id);
		userService.deleteUserById(id);
		return ResponseEntity.ok("User Deleted Successfully");
	}
}
