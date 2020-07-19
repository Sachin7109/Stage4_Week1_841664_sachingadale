package com.cognizant.springlearn;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

//	public void displayCountry(){
//		LOGGER.info("START");
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		
//		Country country = (Country) context.getBean("country", Country.class);		
//		LOGGER.debug("Country : {}", country.toString());
//		
//		LOGGER.info("END");
//	}
	
	public void displayCountries(){
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> country = context.getBean("countryList", java.util.ArrayList.class);
		
		LOGGER.debug("Country : {}", country.toString());
				
		LOGGER.info("END");
	}

	public static void main(String[] args){
		SpringApplication.run(SpringLearnApplication.class, args);

		SpringLearnApplication sApplication = new SpringLearnApplication();
		//sApplication.displayCountry();
		sApplication.displayCountries();
	}
}
