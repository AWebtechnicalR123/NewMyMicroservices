package com.cgi.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.user.entities.User;
import com.cgi.user.service.UserService;

@RestController
//@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	//create
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user){ //request Body to pass data in JSON
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//single user Get
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User user = userService.getUserId(userId);
		return ResponseEntity.ok(user);
	}
	
	//all user get
	@GetMapping("/get")
	public List<User> getAllUser(){
//		List<User> allUser = userService.getAllUser();
//		return ResponseEntity.ok(allUser);
		return userService.getAllUser();
	}
	
	//delete single user
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteSingleUser(@PathVariable String userId){
		String dlUser = userService.deleteUserId(userId);
		return ResponseEntity.ok(dlUser);
	}
	
	//update single user
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateSingleUser(@PathVariable String userId, @RequestBody User user){
		User user1 = userService.updateUserId(userId, user);
		return ResponseEntity.ok(user1);
	}
	
}
