package com.cgi.user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user") //to change table name
public class User {
	@Id
	@Column(name="id") //change column name
	private String userId;
	@Column(name="Name", length=20)
	private String name;
	private String email;
	private String about;
	//other user property

}
