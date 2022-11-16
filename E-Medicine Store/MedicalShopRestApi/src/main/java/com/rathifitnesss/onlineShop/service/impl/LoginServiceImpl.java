package com.rathifitnesss.onlineShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rathifitnesss.onlineShop.entity.Login;
import com.rathifitnesss.onlineShop.repository.LoginRepository;
import com.rathifitnesss.onlineShop.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public List<Login> getAllLoginDetails() {
		// TODO Auto-generated method stub
		return loginRepository.findAll();
	}

	@Override
	public Login saveLoginDetail(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.save(login);
	}

}
