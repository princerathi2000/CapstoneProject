package com.rathifitnesss.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rathifitnesss.onlineShop.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
