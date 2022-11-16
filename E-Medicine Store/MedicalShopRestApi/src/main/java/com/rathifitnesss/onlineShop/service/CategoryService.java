package com.rathifitnesss.onlineShop.service;

import java.util.List;


import com.rathifitnesss.onlineShop.entity.Category;

public interface CategoryService {

	List<Category> getAllCategory();
	Category saveCategory(Category category);
	Category getCategoryById(Integer id);
	Category updateCategory(Category category);
	void deleteCategoryById(Integer id);
	
}
