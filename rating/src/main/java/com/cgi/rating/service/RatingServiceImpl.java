package com.cgi.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.rating.entity.Rating;
import com.cgi.rating.repository.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepo ratingRepository;
	
	@Override
	public Rating saveRating(Rating ratings) {
		return ratingRepository.save(ratings);
	}

	@Override
	public List<Rating> getRatings() {
//		System.out.print(ratingRepository.findById("651ee599b0a70e5fa4e70bd7").get().getUserId());
		return ratingRepository.findAll();
	}
	
	
}
