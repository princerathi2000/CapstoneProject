package com.rathifitnesss.onlineShop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rathifitnesss.onlineShop.entity.User;
import com.rathifitnesss.onlineShop.service.UserService;

@CrossOrigin(origins= {"http://localhost:4200/","http://localhost:64523/"})
@RestController
//@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/userList")
//@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// handler method to handle list user and return mode and view
	@GetMapping("/users")
	public List<User> listUsers(Model model) {
		model.addAttribute("user", userService.getAllUser());
		return userService.getAllUser();
	}
	
	@GetMapping("/users/new")
	public String createUserForm(Model model) {
		
		// create user object to hold user form data
		User user = new User();
		model.addAttribute("user", user);
		return "create_user";
		
	}
	
//	@PostMapping("/user")
//	public User saveUser(@RequestBody User user) {
//		System.out.println(user);
//
//		return userService.saveUser(user);
////		return "redirect:/user";
//	}
	
	//save user according to teacher
//	@PostMapping("/users")
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addUser(@RequestBody User user){
		User resp=userService.saveUser(user);
		if(resp!=null)
			return new ResponseEntity<Object>(resp,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while inserting a data",
					HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/user/edit/{id}")
	public String editUserForm(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_user";
	}

	@PostMapping("/user/{id}")
	public String updateUser(@PathVariable Integer id,
			@ModelAttribute("user") User user,
			Model model) {
		
		// get user from database by id
		User existingUser = userService.getUserById(id);
		existingUser.setId(id);
		existingUser.setName(user.getName());
		existingUser.setPassword(user.getPassword());
		existingUser.setEmail(user.getEmail());
		
		// save updated user object
		userService.updateUser(existingUser);
		return "redirect:/user";		
	}
	
	// handler method to handle delete user request
	
	@GetMapping("/user/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userService.deleteUserById(id);
		return "redirect:/user";
	}
	
	
}
