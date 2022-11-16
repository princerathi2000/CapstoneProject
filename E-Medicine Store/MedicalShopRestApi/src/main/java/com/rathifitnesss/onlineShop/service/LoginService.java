package com.rathifitnesss.onlineShop.service;

import java.util.List;

import com.rathifitnesss.onlineShop.entity.Login;
import com.rathifitnesss.onlineShop.entity.Product;

public interface LoginService {

	List<Login> getAllLoginDetails();
	Login saveLoginDetail(Login login);
}
