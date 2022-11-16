package com.rathifitnesss.onlineShop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import lombok.Data;

import javax.persistence.Id;

@Entity
@Data
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	
}
