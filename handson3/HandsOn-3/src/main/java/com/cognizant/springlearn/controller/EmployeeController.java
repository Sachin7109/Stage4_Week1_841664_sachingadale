package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.HandsOn3Application;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn3Application.class);

	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees() {
		LOGGER.info("START");

		LOGGER.info("END");
		return EmployeeService.getAllEmployees();
	}
}
