package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.service.EmployeeNotFoundException;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees() {
		LOGGER.info("START");

		LOGGER.info("END");
		return EmployeeService.getAllEmployees();
	}

	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable(value = "id") int employeeId, @Valid @RequestBody Employee employeeDetails)
			throws EmployeeNotFoundException {

		LOGGER.info("START");

		Employee updatedEmployee = EmployeeService.updateEmployee(employeeId, employeeDetails);

		LOGGER.debug(updatedEmployee.toString());
		LOGGER.info("END");

	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable(value = "id") int employeeId, @Valid @RequestBody Employee employeeDetails)
			throws EmployeeNotFoundException {

		LOGGER.info("START");

		Employee deletedEmployee = EmployeeService.deleteEmployee(employeeId, employeeDetails);

		LOGGER.debug(deletedEmployee.toString());
		LOGGER.info("END");

	}

}
