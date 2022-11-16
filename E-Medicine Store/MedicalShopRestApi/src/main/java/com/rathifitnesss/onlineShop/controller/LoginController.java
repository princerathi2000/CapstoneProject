package com.rathifitnesss.onlineShop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rathifitnesss.onlineShop.entity.Login;
import com.rathifitnesss.onlineShop.entity.Product;
import com.rathifitnesss.onlineShop.entity.User;
import com.rathifitnesss.onlineShop.service.LoginService;
import com.rathifitnesss.onlineShop.service.ProductService;
import com.rathifitnesss.onlineShop.service.UserService;


//@Controller
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserService userService;

	@Autowired
	LoginService loginService;

	
	//to display the main frame
		// handler method to handle list product and return mode and view
			@GetMapping("/login")
			public List<Login> displayProducts(Model model) {
//				
				model.addAttribute("login", loginService.getAllLoginDetails());
				return loginService.getAllLoginDetails();
//				model.addAttribute("user", userService.getAllUser());
//				return "cart";
			}
			
			String redirect="";
			@PostMapping("/login")
			public String saveLoginDetails(@ModelAttribute("login") Login login) {
			
				if(login.getEmail().equals("admin@gmail.com"))
				{
					if(login.getPassword().equals("admin123"))
					{
						redirect= "redirect:/adminhome";
					}
				}
				else
				{
//					ArrayList<User> users=new ArrayList<User>();
//					users.add(userService.getAllUser().get(0));
//					users.toString();
					redirect="redirect:/shop";
				}
				//				loginService.saveLoginDetail(login);
				return redirect;
			}
			
//			@PostMapping("/login")
//			public String saveProduct(@ModelAttribute("user") User user){
//				
////				List<User> userList=userService.getAllUser();
////				while(user.getEmail()!=null)
////				{
////					if(user.getEmail().equals("ansul"))
////					{
////						return "shop";
////					}
////					else {
////						break;
////					}
////				}
				
			
			
			
//					newProduct.setId(product.getCategory().getId());
//					newProduct.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
//					newProduct.setName(product.getName());
//					newProduct.setDescription(product.getDescription());
//					newProduct.setPrice(product.getPrice());
//					String imageUUID;
//					imgName="Blank";
//					
//					if(!file.isEmpty())
//					{
//					imageUUID=file.getOriginalFilename();
//					Path fileNameAndPath=Paths.get(uploadDir,imageUUID);
//					Files.write(fileNameAndPath,file.getBytes());
//					}
//					else
//					{
//					imageUUID=imgName;
//					}
//					
//					product.setPhoto(imageUUID);
//					productService.saveProduct(product);
					
//					return "redirect:/admin/products";
//					}
			
			@GetMapping("/index")
			public String displayIndex()
			{
				return "index";
			}
			
			@GetMapping("/adminhome")
			public String displayAdminHome()
			{
				return "adminHome";
			}
/*	
	// handler method to handle list product and return mode and view
	@GetMapping("/product")
	public String listProducts(Model model) {
		model.addAttribute("product", productService.getAllProduct());
		return "product";
	}
	
		
		//to view product
		@GetMapping("/shop/viewproduct/{id}")
		public String viewProduct(@PathVariable Integer id, Model model) {
			model.addAttribute("product", productService.getProductById(id));
			return "viewProduct";
		}		
	
	@GetMapping("/product/new")
	public String createProductForm(Model model) {
		
		// create product object to hold product form data
		Product product = new Product();
		model.addAttribute("product", product);
		return "create_product";
		
	}
	
	@PostMapping("/product")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/product";
	}
	
	@GetMapping("/product/edit/{id}")
	public String editProductForm(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "edit_product";
	}

	@PostMapping("/product/{id}")
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
		return "redirect:/product";		
	}
	
	// handler method to handle delete product request
	
	@GetMapping("/product/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		productService.deleteProductById(id);
		return "redirect:/product";
	}
	
*/	
	
}
