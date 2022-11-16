package com.rathifitnesss.onlineShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rathifitnesss.onlineShop.entity.Category;
import com.rathifitnesss.onlineShop.repository.CategoryRepository;
import com.rathifitnesss.onlineShop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
//	public CategoryServiceImpl(CategoryRepository categoryRepository) {
//		super();
//		this.categoryRepository = categoryRepository;
//	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(Integer id) {
		categoryRepository.deleteById(id);
		
	}

}
