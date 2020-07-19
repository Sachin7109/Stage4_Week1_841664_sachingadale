package com.cognizant.truyum.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	@Autowired
	private  MenuItemDao menuItemDao;
	
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("MenuItemService.getMenuItemListCustomer() START");
		LOGGER.info("MenuItemService.getMenuItemListCustomer() END");
		
		return menuItemDao.getMenuItemListCustomer();
	}

	public MenuItem getMenuItem(Long id) {
		LOGGER.info("MenuItemService.getMenuItem() START");
		LOGGER.info("MenuItemService.getMenuItem() END");
		
		return menuItemDao.getmenuItem(id);
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("MenuItemService.modifyMenuItem() START");
		LOGGER.info("MenuItemService.modifyMenuItem() END");
		
		menuItemDao.modifyMenuItem(menuItem);
	}
	
}
