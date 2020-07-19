package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class CartDaoCollectionImpl implements CartDao {

	@Autowired
	MenuItemDao menuItemDao;

	ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
	ArrayList<MenuItem> ITEM_LIST = context.getBean("menuList", ArrayList.class);

	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpl.class);

	private HashMap<String, Cart> userCarts = new HashMap<String, Cart>();

	@Override
	public void addCartItem(String userId, Long menuItemId) {
		LOGGER.info("START");

		MenuItem menuItem = menuItemDao.getmenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			ArrayList<MenuItem> menuItemList = userCarts.get(userId).getCartItemList();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart(userId, new ArrayList<MenuItem>());
			cart.getCartItemList().add(menuItem);
			userCarts.put(userId, cart);
		}
		LOGGER.debug("userId: {}", userId);
		LOGGER.debug("menuItemId: {}", menuItemId);
		LOGGER.debug("UserCart : {}", userCarts);
		LOGGER.info("END");
	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		LOGGER.info("START");

		if (userCarts.containsKey(userId)) {
			double total = 0.0;
			ArrayList<MenuItem> menuItemList = userCarts.get(userId).getCartItemList();
			if (menuItemList.isEmpty()) {
				throw new CartEmptyException();
			} else {

				for (int i = 0; i < menuItemList.size(); i++) {
					total += menuItemList.get(i).getPrice();
				}
			}
			LOGGER.debug("CartItemList : {}", menuItemList);
			LOGGER.debug("Total: {} ", total);

			LOGGER.info("END");
			return menuItemList;

		} else {
			LOGGER.info("END");
			throw new CartEmptyException();
		}
	}

	@Override
	public void deleteCartItem(String userId, Long menuItemId) {
		LOGGER.info("START");

		if (userCarts.containsKey(userId)) {
			ArrayList<MenuItem> menuItemList = userCarts.get(userId).getCartItemList();

			for (int i = 0; i < menuItemList.size(); i++) {
				if (menuItemList.get(i).getId() == menuItemId) {
					menuItemList.remove(i);
				}
			}

			LOGGER.debug("userId: {}", userId);
			LOGGER.debug("menuItemId: {}", menuItemId);
			LOGGER.debug("CartItemList: {}", menuItemList);
			LOGGER.debug("UserCarts: {}", userCarts);

			LOGGER.info("END");

		} else {
			LOGGER.info("END");
			throw new MenuItemNotFoundException();
		}

	}

}
