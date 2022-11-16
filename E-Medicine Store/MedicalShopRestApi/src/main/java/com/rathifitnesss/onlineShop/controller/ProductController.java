package com.rathifitnesss.onlineShop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rathifitnesss.Global.GlobalData;
import com.rathifitnesss.onlineShop.entity.Product;
import com.rathifitnesss.onlineShop.service.CategoryService;
import com.rathifitnesss.onlineShop.service.ProductService;

@CrossOrigin(origins= {"http://localhost:4200/","http://localhost:64523/"})
//@Controller
@RestController
@RequestMapping("/pro")
public class ProductController {
	
	public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/Photos";

	 @Autowired
	 ProductService productService;
	 @Autowired
	 CategoryService categoryService;
	
	
	// handler method to handle list product and return mode and view
	@GetMapping("/admin/products")
	public List<Product> listProducts(Model model) {
		model.addAttribute("product", productService.getAllProduct());
		model.addAttribute("category", categoryService.getAllCategory());
//		return "product";
		return productService.getAllProduct();
	}
	
	//to display the main frame
	// handler method to handle list product and return mode and view
		@GetMapping("/shop")
		public String displayProducts(Model model) {
			model.addAttribute("cartCount",GlobalData.cart.size());
			model.addAttribute("product", productService.getAllProduct());
			model.addAttribute("category", categoryService.getAllCategory());
			return "shop";
		}
		
		//short by category
		@GetMapping("/shop/category/{id}")
		public String shopByCategory(Model model,@PathVariable int id) {
			model.addAttribute("cartCount",GlobalData.cart.size());
			model.addAttribute("product", productService.getAllProductByCategory(id));
			model.addAttribute("category", categoryService.getAllCategory());
			return "shop";
		}
		
		//to view product
		@GetMapping("/admin/products/{id}")
		public Product viewProduct(@PathVariable Integer id, Model model) {
			model.addAttribute("cartCount",GlobalData.cart.size());
			model.addAttribute("product", productService.getProductById(id));
//			return "viewProduct";
			return productService.getProductById(id);
		}		
	
	@GetMapping("/admin/product/new")
	public String createProductForm(Model model) {
		
		// create product object to hold product form data
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("category", categoryService.getAllCategory());
		return "create_product";
	}
	
//	@PostMapping("/admin/product")
//	public String saveProduct(@ModelAttribute("product") Product product) {
//		productService.saveProduct(product);
//		return "redirect:/admin/products";
//	}
	
	@PostMapping("/admin/products")
	public String saveProduct(@RequestBody Product product) throws IOException {
		
		Product newProduct=new Product();
		newProduct.setId(product.getCategory().getId());
		newProduct.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
		newProduct.setName(product.getName());
		newProduct.setDescription(product.getDescription());
		newProduct.setPrice(product.getPrice());
		String imageUUID="";
//		imgName=product.getPhoto();
		
//		if(!file.isEmpty())
//		{
//			imageUUID=file.getOriginalFilename();
//			Path fileNameAndPath=Paths.get(uploadDir,imageUUID);
//			Files.write(fileNameAndPath,file.getBytes());
//		}
//		else
//		{
//			imageUUID=imgName;
//		}
		
		product.setPhoto(product.getPhoto());
		productService.saveProduct(product);
		System.out.println("into POST method");
		return "redirect:/admin/products";
	}
	
	
	//got to edit page 
	@GetMapping("/admin/product/edit/{id}")
	public String editProductForm(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		model.addAttribute("category", categoryService.getAllCategory());
		return "edit_product";
	}

	//handel to update the product
	@PostMapping("/admin/product/{id}")
	public String updateProduct(@PathVariable Integer id,
			@ModelAttribute("product") Product product,
			Model model) {
		
		// get product from database by id
		Product existingProduct = productService.getProductById(id);
		existingProduct.setId(id);
		existingProduct.setCategory(product.getCategory());
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setPhoto(product.getPhoto());
		
		// save updated product object
		productService.updateProduct(existingProduct);
		return "redirect:/admin/products";		
	}
	
	// handler method to handle delete product request
	@GetMapping("/admin/product/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		productService.deleteProductById(id);
		return "redirect:/admin/products";
	}
	
}
