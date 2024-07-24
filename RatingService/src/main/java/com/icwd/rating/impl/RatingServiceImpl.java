package com.icwd.rating.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icwd.rating.entities.Rating;
import com.icwd.rating.repos.RatingRepository;
import com.icwd.rating.services.RatingServices;

@Service
public class RatingServiceImpl implements RatingServices{
	
	@Autowired
	private RatingRepository repo;

	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		String randomUUID = UUID.randomUUID().toString();
		rating.setRatingId(randomUUID);
		return repo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return repo.findRatingByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return repo.findRatingByHotelId(hotelId);
	}

}
