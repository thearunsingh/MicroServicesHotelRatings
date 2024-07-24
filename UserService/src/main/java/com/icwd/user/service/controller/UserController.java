package com.icwd.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icwd.user.service.entities.User;
import com.icwd.user.service.payload.ApiResponse;
import com.icwd.user.service.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userservice;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUsers = userservice.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId)
	{
		User user = userservice.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> saveUser(@RequestBody User user)
	{
		userservice.saveUser(user);
		ApiResponse response = ApiResponse.builder().message("Successfully Created User").success(true).status(HttpStatus.CREATED).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.CREATED);
	}

}
