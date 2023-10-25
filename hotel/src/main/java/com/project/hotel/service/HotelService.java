package com.project.hotel.service;

import java.util.List;

import com.project.hotel.entity.Hotel;

public interface HotelService {
	Hotel addHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getSingleHotel(String id);
	
	String deleteHotel(String id);
	
	Hotel updateHotelDetails(String id, Hotel hotel);

}
