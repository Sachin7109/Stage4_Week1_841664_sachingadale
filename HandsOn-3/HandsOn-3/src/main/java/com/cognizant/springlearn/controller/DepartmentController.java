package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.HandsOn3Application;
import com.cognizant.springlearn.entity.Department;
import com.cognizant.springlearn.service.DepartmentService;

@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn3Application.class);

	@GetMapping("/departments")
	public ArrayList<Department> getAllDepartments() {
		LOGGER.info("START");

		LOGGER.info("END");
		return DepartmentService.getAllDepartments();
	}
}
