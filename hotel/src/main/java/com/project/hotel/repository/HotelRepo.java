package com.project.hotel.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.project.hotel.entity.Hotel;

@Repository
public interface HotelRepo extends ElasticsearchRepository<Hotel, String>{

}
