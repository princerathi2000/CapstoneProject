package com.rathifitnesss.onlineShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rathifitnesss.onlineShop.entity.Category;
import com.rathifitnesss.onlineShop.entity.Product;
import com.rathifitnesss.onlineShop.entity.User;
import com.rathifitnesss.onlineShop.service.CategoryService;

@CrossOrigin(origins= {"http://localhost:4200/","http://localhost:64523/"})
@RestController
@RequestMapping("/categoryList")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	// handler method to handle list product and return mode and view
		@GetMapping("/categories")
		public List<Category> listCategories(Model model) {
			System.out.println(categoryService.getAllCategory());
			model.addAttribute("category", categoryService.getAllCategory());
			return categoryService.getAllCategory();
		}
	
		@GetMapping("/admin/categories/add")
		public String createCategoryForm(Model model) {
			
			// create product object to hold product form data
			Category category = new Category();
			model.addAttribute("category", category);
			return "create_category";
		}
		
	    @PostMapping(value = "/categories", consumes = MediaType.APPLICATION_JSON_VALUE)
		public String saveCategory(@RequestBody Category category) {
			categoryService.saveCategory(category);
			return "redirect:/admin/categories";
		}
		
		//got to edit page 
		@GetMapping("/admin/category/edit/{id}")
		public String editCategoryForm(@PathVariable Integer id, Model model) {
			model.addAttribute("category", categoryService.getCategoryById(id));
			return "edit_category";
		}

		//handel to update the category
		@PostMapping("/admin/category/{id}")
		public String updateCategory(@PathVariable Integer id,
				@ModelAttribute("category") Category category,
				Model model) {
			
			// get product from database by id
			Category existingCategory = categoryService.getCategoryById(id);
			existingCategory.setId(id);
			existingCategory.setName(category.getName());
			
			// save updated product object
			categoryService.updateCategory(existingCategory);
			return "redirect:/admin/categories";		
		}
		
		// handler method to handle delete category request
		
		@GetMapping("/admin/category/{id}")
		public String deleteCategory(@PathVariable Integer id) {
			categoryService.deleteCategoryById(id);
			return "redirect:/admin/categories";
		}
}
