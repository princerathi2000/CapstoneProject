package com.rathifitnesss.onlineShop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Id;


@Entity
@Table(name="category")
@Data
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private int id;
	
	@Column(name="name",nullable = false)
	private String name;
	
}
