package com.rathifitnesss.onlineShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rathifitnesss.onlineShop.repository.CategoryRepository;
import com.rathifitnesss.onlineShop.repository.ProductRepository;
import com.rathifitnesss.onlineShop.repository.UserRepository;


@SpringBootApplication
public class OnlineShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
}
