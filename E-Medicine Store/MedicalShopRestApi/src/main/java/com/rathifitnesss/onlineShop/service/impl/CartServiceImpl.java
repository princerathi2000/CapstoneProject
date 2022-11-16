//package com.rathifitnesss.onlineShop.service.impl;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.rathifitnesss.onlineShop.entity.Cart;
//import com.rathifitnesss.onlineShop.entity.Product;
//import com.rathifitnesss.onlineShop.repository.CartRepository;
//import com.rathifitnesss.onlineShop.repository.ProductRepository;
//import com.rathifitnesss.onlineShop.service.CartService;
//import com.rathifitnesss.onlineShop.service.ProductService;
//
//@Service
//public class CartServiceImpl implements CartService{
//
//	private CartRepository cartRepository;
//	private ProductRepository productRepository;
//
//	public CartServiceImpl(CartRepository cartProductRepo) {
//		super();
//		this.cartRepository = cartProductRepo;
//	}
//	
//	
//	@Override
//	public List<Product> getAllCartProduct() {
//		
//		
//		return productRepository.findAll();
//	}
//
//	@Override
//	public Cart saveCartProduct(Cart cart) {
//		return cartRepository.save(cart);
//	}
//
//	@Override
//	public Cart getCartProductById(Integer id) {
//		return cartRepository.findById(id).get();
//	}
//
//	@Override
//	public Cart updateCartProduct(Cart cart) {
//		return cartRepository.save(cart);
//	}
//
//	@Override
//	public void deleteCartProductById(Integer id) {
//		cartRepository.deleteById(id);	
//	}
//
//
//}
