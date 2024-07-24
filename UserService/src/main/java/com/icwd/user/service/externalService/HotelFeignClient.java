package com.icwd.user.service.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.icwd.user.service.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelFeignClient {

	@GetMapping("/hotels/{hotelId}")
	Hotel gethotel(@PathVariable String hotelId);
	
}
