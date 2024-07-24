package com.icwd.rating.controller;

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

import com.icwd.rating.entities.Rating;
import com.icwd.rating.services.RatingServices;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingServices service;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		Rating create = service.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(create);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating()
	{
		return ResponseEntity.ok(service.getAllRating());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(service.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
	}

}
