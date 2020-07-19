package com.cognizant.truyum.controller;

import java.net.URI;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	@Autowired
	MenuItemService menuItemService;

	@GetMapping
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("MenuItemController.getMenuItemListCustomer() START");
		LOGGER.info("MenuItemController.getMenuItemListCustomer() END");
		return menuItemService.getMenuItemListCustomer();
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable("id") Long id) {
		LOGGER.info("MenuItemController.getMenuItem() START");
		LOGGER.info("MenuItemController.getMenuItem() END");
		return menuItemService.getMenuItem(id);
	}

	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		LOGGER.info("MenuItemController.modifyMenuItem() START");
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(menuItem.getId())
//				.toUri();
	
		LOGGER.info("MenuItemController.modifyMenuItem() END");
		menuItemService.modifyMenuItem(menuItem);
	}

}
