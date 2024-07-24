package com.icwd.rating.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icwd.rating.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	
    @Query(value = "SELECT * FROM ratings r WHERE r.user_id ilike :userId", nativeQuery = true)
	List<Rating> findRatingByUserId(@Param("userId") String userId);
	
    @Query(value = "SELECT * FROM ratings r WHERE r.hotel_id ilike :hotelId", nativeQuery = true)
	List<Rating> findRatingByHotelId(@Param("hotelId") String hotelId);

}
