package com.project.hotel.controller;

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

import com.project.hotel.entity.Hotel;
import com.project.hotel.service.HotelService;

@RestController
@RequestMapping("hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotel(hotel));
	}
	
	@GetMapping("/allHotels")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSingleHotel(@PathVariable String id){
		return ResponseEntity.ok(hotelService.deleteHotel(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotelDetails(@PathVariable String id, @RequestBody Hotel hotel){
		return ResponseEntity.ok(hotelService.updateHotelDetails(id, hotel));
	}
	

}
