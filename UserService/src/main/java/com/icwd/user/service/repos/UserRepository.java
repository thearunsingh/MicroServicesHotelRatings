package com.icwd.user.service.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icwd.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
