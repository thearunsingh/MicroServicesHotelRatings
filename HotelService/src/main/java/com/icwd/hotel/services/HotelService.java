package com.icwd.hotel.services;

import java.util.List;

import com.icwd.hotel.entities.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getSingleHotel(String hotelId);

}
