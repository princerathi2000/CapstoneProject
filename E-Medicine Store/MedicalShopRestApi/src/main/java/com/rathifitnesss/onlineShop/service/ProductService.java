package com.rathifitnesss.onlineShop.service;

import java.util.List;

import com.rathifitnesss.onlineShop.entity.Product;


public interface ProductService {

	List<Product> getAllProduct();
	Product saveProduct(Product product);
	Product getProductById(Integer id);
	Product updateProduct(Product product);
	void deleteProductById(Integer id);
	List<Product> getAllProductByCategory(int id);
	List<Product> getAllProductByName(String name);
}
