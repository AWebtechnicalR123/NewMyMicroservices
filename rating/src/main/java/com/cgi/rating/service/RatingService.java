package com.cgi.rating.service;

import java.util.List;

import com.cgi.rating.entity.Rating;

public interface RatingService {
	Rating saveRating(Rating ratings);
	List<Rating> getRatings();
}
