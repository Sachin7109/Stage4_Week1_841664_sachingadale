package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.entity.Country;

@Service
public class CountryService {

	public Country getCountry(String code) {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countryList = context.getBean("countryList",ArrayList.class);

//		method 1:	
//		for (Country country : countryList) {
//			if(country.getCode().equalsIgnoreCase(code))
//				return country;
//		}
//		return null;
		
//		method 2:
//		Lambda expression can also be used instead of iterating the country list
		return countryList.stream().filter(country -> country.getCode().equalsIgnoreCase(code)).findFirst().get();

	}

}
