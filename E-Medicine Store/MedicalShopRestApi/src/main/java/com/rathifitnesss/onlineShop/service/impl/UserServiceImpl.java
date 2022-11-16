package com.rathifitnesss.onlineShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rathifitnesss.onlineShop.entity.User;
import com.rathifitnesss.onlineShop.repository.UserRepository;
import com.rathifitnesss.onlineShop.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepository = userRepo;
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);	
	}



}
