package com.icwd.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.repos.HotelRepository;
import com.icwd.hotel.services.HotelService;
import com.icwd.hotel.services.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepository repo;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomUUID = UUID.randomUUID().toString();
		hotel.setId(randomUUID);
		return repo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Hotel getSingleHotel(String hotelId) {
		// TODO Auto-generated method stub
		return repo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found !! : "+hotelId));
	}

}
