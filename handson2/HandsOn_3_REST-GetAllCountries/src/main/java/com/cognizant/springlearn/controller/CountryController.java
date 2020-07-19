package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.HandsOn3RestGetAllCountries;
import com.cognizant.springlearn.entity.Country;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn3RestGetAllCountries.class);
	
//	@RequestMapping(value = "/country")
//	public Country getCountryIndia() {
//		LOGGER.info("START");
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		Country country = context.getBean("in", Country.class);
//		
//		LOGGER.info("END");
//		return country;
//	}
	
	@GetMapping(value = "/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);
		
		LOGGER.info("END");
		return countryList;
	}

}
