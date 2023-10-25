package com.project.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotel.entity.Hotel;
import com.project.hotel.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired 
	private HotelRepo hotelRepository;
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		return null;
	}

	@Override
	public List<Hotel> getAllHotels() {
		Iterable<Hotel> hotls = hotelRepository.findAll();
		List<Hotel> listOfHotels = new ArrayList<>();
		for(Hotel hotl:hotls) {
			listOfHotels.add(hotl);
		}
		return listOfHotels;
	}

	@Override
	public Hotel getSingleHotel(String id) {
		return hotelRepository.findById(id).get();
	}

	@Override
	public String deleteHotel(String id) {
		hotelRepository.deleteById(id);
		return "Hotel successfully delted";
	}

	@Override
	public Hotel updateHotelDetails(String id, Hotel hotel) {
		Hotel hotl = hotelRepository.findById(id).get();
		hotl.setName(hotel.getName());
		hotl.setLocation(hotel.getLocation());
		hotl.setAbout(hotel.getAbout());
		return hotelRepository.save(hotl);
	}
	

}
