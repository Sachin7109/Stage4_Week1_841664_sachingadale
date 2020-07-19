package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public void displayDate() throws ParseException {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		Date date = format.parse("31/12/2018");
		String strDate = format.format(date);

		LOGGER.debug(strDate);

		LOGGER.info("END");
	}

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);

		SpringLearnApplication sApplication = new SpringLearnApplication();
		sApplication.displayDate();
	}
}
