package com.icwd.user.service.services;

import java.util.List;

import com.icwd.user.service.entities.User;

public interface UserServices {
	
	User saveUser(User user);
	List<User> getAllUsers();
	User getUser(String userId);

}
