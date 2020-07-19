package com.cognizant.truyum.dao;

import java.util.ArrayList;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	void addCartItem(String userId, Long menuItemId);

	ArrayList<MenuItem> getAllCartItems(String userId) throws CartEmptyException;

	void deleteCartItem(String userId, Long menuItemId);

}
