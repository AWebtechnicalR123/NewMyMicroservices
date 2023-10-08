package com.cgi.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.rating.entity.Rating;
import com.cgi.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/save")
	public Rating saveSingleRating(@RequestBody Rating rating) {
		return ratingService.saveRating(rating);
	}
	
	@GetMapping("/get")
	public List<Rating> getRatingList(){
		return ratingService.getRatings();
	}
}
