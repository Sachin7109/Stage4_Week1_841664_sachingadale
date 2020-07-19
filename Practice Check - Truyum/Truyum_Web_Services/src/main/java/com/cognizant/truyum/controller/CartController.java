package com.cognizant.truyum.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable("userId") String userId, @PathVariable("menuItemId") Long menuItemId) {
		LOGGER.info("CartController.addCartItem() Start");
		cartService.addCartItem(userId, menuItemId);
		LOGGER.info("CartController.addCartItem() Ends");
	}
	
	@GetMapping("/{userId}")
	public ArrayList<MenuItem> getAllCartItems(@PathVariable("userId") @Valid String userId) {
		LOGGER.info("CartController.getAllCartItems() Start");
		return cartService.getAllCartItems(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItems(@PathVariable("userId") String userId, @PathVariable("menuItemId") Long menuItemId) {
		cartService.deleteCartItem(userId, menuItemId);
	}
}