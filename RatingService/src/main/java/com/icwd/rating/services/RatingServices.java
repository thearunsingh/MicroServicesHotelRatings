package com.icwd.rating.services;

import java.util.List;

import com.icwd.rating.entities.Rating;

public interface RatingServices {
	
	Rating create(Rating rating);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);

}
