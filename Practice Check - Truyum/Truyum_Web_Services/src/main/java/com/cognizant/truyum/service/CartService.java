package com.cognizant.truyum.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	@Autowired
	CartDao cartDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	public void addCartItem(String userId, Long menuItemId) {
		LOGGER.info("CartService.addCartItem START");
		cartDao.addCartItem(userId, menuItemId);
		LOGGER.info("CartService.addCartItem END");
	}

	public ArrayList<MenuItem> getAllCartItems(String userId) {
		LOGGER.info("CartService.getAllCartItems START");
		LOGGER.info("CartService.getAllCartItems END");
		return cartDao.getAllCartItems(userId);		
	}

	public void deleteCartItem(String userId, Long menuItemId) {
		LOGGER.info("CartService.deleteCartItem START");
		cartDao.deleteCartItem(userId, menuItemId);
		LOGGER.info("CartService.deleteCartItem END");
	}

}
