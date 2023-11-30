package com.cgi.user.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cgi.user.entities.User;
import com.cgi.user.exception.UserNotFoundException;
import com.cgi.user.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepository;
	
	@Autowired
	private RestTemplate restTemplate; //if show error add bean 
	
	private Logger logger=LoggerFactory.getLogger(UserService.class);

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	//get single user using id
	@Override
	public User getUserId(String userId) {
		User user =  userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with given Id is not found on server "+userId));
		//fetch rating of the above user from Rating Service
		
		ArrayList forObject = restTemplate.getForObject("http://localhost:8083/ratings/get/users/651ee7f7b0a70e5fa4e70be2", ArrayList.class);
		logger.info("{} ",forObject);
		
		return user;
	}

	@Override
	public String deleteUserId(String userId) {
		userRepository.deleteById(userId);
		return "User deleted successfully";
	}

	@Override
	public User updateUserId(String userId, User user) {
		User user1 = userRepository.findById(userId).get();
		user1.setName(user.getName());
		return userRepository.save(user1);
	}
	
}
