package com.rathifitnesss.onlineShop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rathifitnesss.onlineShop.entity.Product;
import com.rathifitnesss.onlineShop.repository.ProductRepository;
import com.rathifitnesss.onlineShop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepository = productRepo;
	}
	
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);	
	}

	@Override
	public List<Product> getAllProductByCategory(int id) {
		// TODO Auto-generated method stub
		return productRepository.findAllByCategory_Id(id);
	}

	@Override
	public List<Product> getAllProductByName(String name) {
		// TODO Auto-generated method stub
		return productRepository.findAllByName(name);
	}



}
