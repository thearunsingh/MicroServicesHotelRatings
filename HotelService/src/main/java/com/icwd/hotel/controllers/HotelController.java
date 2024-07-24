package com.icwd.hotel.controllers;

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

import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
	{
		Hotel create = service.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(create);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel()
	{
		List<Hotel> allHotel = service.getAllHotel();
		return ResponseEntity.ok(allHotel);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId)
	{
		Hotel singleHotel = service.getSingleHotel(hotelId);
		return ResponseEntity.ok(singleHotel);
	}

}
