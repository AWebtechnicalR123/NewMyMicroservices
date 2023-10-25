package com.project.hotel.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName="hotel")
public class Hotel {
	@Id
	@Field(value="hotelId")
	private String id;
	
	@Field(value="hotelName")
	private String name;
	
	private String location;
	
	private String about;

}
