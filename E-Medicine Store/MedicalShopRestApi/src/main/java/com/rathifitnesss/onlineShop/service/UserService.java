package com.rathifitnesss.onlineShop.service;

import java.util.List;

import com.rathifitnesss.onlineShop.entity.User;

public interface UserService {

	List<User> getAllUser();
	User saveUser(User user);
	User getUserById(Integer id);
	User updateUser(User user);
	void deleteUserById(Integer id);
}
