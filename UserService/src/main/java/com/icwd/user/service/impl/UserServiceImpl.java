package com.icwd.user.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.icwd.user.service.entities.Hotel;
import com.icwd.user.service.entities.Rating;
import com.icwd.user.service.entities.User;
import com.icwd.user.service.exceptions.ResourseNotFoundException;
import com.icwd.user.service.externalService.HotelFeignClient;
import com.icwd.user.service.repos.UserRepository;
import com.icwd.user.service.services.UserServices;

@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	UserRepository repo;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	HotelFeignClient hotelfeignclient;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUUID = UUID.randomUUID().toString();
		user.setUserId(randomUUID);
		return repo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
	User user = repo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User with given Id not found on server : "+userId));
	Rating[] ratingArray = template.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
	List<Rating> list = Arrays.asList(ratingArray);
	List<Rating> collect = list.stream().map(rating -> {
		//ResponseEntity<Hotel> forEntity = template.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
	    hotelfeignclient.gethotel(rating .getHotelId());
		Hotel hotel = hotelfeignclient.gethotel(rating .getHotelId());
	    rating.setHotel(hotel);
	    return rating;
	}).collect(Collectors.toList());
	user.setRatings(collect);
	return user;
	}

}
