package com.User_Microservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User_Microservice.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
}
