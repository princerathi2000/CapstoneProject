package com.rathifitnesss.onlineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rathifitnesss.Global.GlobalData;
import com.rathifitnesss.onlineShop.entity.Product;
import com.rathifitnesss.onlineShop.service.ProductService;


@Controller
public class CartController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id)
	{
		GlobalData.cart.add(productService.getProductById(id));
		System.out.println(GlobalData.cart);
		return "redirect:/shop";
	}
	
	@GetMapping("/cart")
	public String cartCreate(Model model) 
	{
		model.addAttribute("cartCount",GlobalData.cart.size());
		model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("productCart",GlobalData.cart);
		System.out.println(GlobalData.cart);
		return "cart";
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String cartRemoveItem(@PathVariable int index	) 
	{
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}

	@GetMapping("/checkout")
	public String checkoutCart() 
	{
		GlobalData.cart.clear();
		return "checkout";
	}
	
}
