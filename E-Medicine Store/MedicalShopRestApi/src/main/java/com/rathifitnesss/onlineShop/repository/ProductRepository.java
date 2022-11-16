package com.rathifitnesss.onlineShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rathifitnesss.onlineShop.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	List<Product> findAllByCategory_Id(int id);
	List<Product> findAllByName(String name);

}
