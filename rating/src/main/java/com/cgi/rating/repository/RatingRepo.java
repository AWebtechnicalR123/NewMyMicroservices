package com.cgi.rating.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgi.rating.entity.Rating;

@Repository
public interface RatingRepo extends MongoRepository<Rating, String>{

}
