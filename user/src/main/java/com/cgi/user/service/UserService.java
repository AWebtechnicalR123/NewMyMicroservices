package com.cgi.user.service;

import java.util.List;

import com.cgi.user.entities.User;

public interface UserService {
	//user operations
	
	//create user
	User saveUser(User user);
	
	//get all User
	List<User> getAllUser();
	
	//get single user given userId
	User getUserId(String userId);
	
	//Delete user given UserId
	String deleteUserId(String userId);
	
	//Update user given userId
	User updateUserId(String userId, User user);
}
	