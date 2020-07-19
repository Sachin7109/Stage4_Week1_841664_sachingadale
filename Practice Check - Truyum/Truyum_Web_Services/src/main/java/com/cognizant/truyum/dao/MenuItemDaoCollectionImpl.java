package com.cognizant.truyum.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
	ArrayList<MenuItem> MENU_ITEMS = context.getBean("menuList", ArrayList.class);

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("MenuItemDaoCollectionImpl.getMenuItemListCustomer() START");
		LOGGER.debug("MenuItemList: {} ", MENU_ITEMS.toString());
		LOGGER.info("MenuItemDaoCollectionImpl.getMenuItemListCustomer() END");
		return MENU_ITEMS;
	}

	@Override
	public MenuItem getmenuItem(Long id) {
		LOGGER.info("MenuItemDaoCollectionImpl.getMenuItem() START");

		MenuItem menuItem = MENU_ITEMS.stream().filter(item -> (item.getId() == id)).findFirst().orElseThrow(() -> {
			throw new MenuItemNotFoundException();
		});

		LOGGER.debug(menuItem.toString());

		LOGGER.info("MenuItemDaoCollectionImpl.getMenuItem() END");
		return menuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("MenuItemDaoCollectionImpl.modifyMenuItem() START");

		MenuItem menuItemUpdate = MENU_ITEMS.stream().filter(menu -> menu.getId() == menuItem.getId()).findFirst()
				.orElseThrow(() -> {
					throw new MenuItemNotFoundException();
				});

//		menuItemUpdate = menuItem; // update old menuItem
		menuItemUpdate.setName(menuItem.getName());
		menuItemUpdate.setPrice(menuItem.getPrice());
		menuItemUpdate.setActive(menuItem.isActive());
		menuItemUpdate.setDateOfLaunch(menuItem.getDateOfLaunch());
		menuItemUpdate.setCategory(menuItem.getCategory());
		menuItemUpdate.setFreeDelivery(menuItem.isFreeDelivery());
		
		LOGGER.info("updated MenuItem:" + menuItemUpdate.toString());

		LOGGER.info("MenuItemDaoCollectionImpl.modifyMenuItem() END");

	}

}
