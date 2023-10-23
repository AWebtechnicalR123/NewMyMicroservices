package com.cgi.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.user.entities.User;
import com.cgi.user.exception.UserNotFoundException;
import com.cgi.user.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserId(String userId) {
		return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with given Id is not found on server"+userId));
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
