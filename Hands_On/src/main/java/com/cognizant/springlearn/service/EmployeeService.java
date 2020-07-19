package com.cognizant.springlearn.service;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDAO;
import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

//	@Transactional
	public ArrayList<Employee> getAllEmployees() {
		return EmployeeDAO.getAllEmployees();
	}

//	@Transactional
	public Employee updateEmployee(int employeeId, Employee employeeDetails) throws EmployeeNotFoundException {
		return EmployeeDAO.updateEmployee(employeeId, employeeDetails);
	}

//	@Transactional
	public Employee deleteEmployee(int employeeId, Employee employeeDetails) throws EmployeeNotFoundException {
		return EmployeeDAO.deleteEmployee(employeeId, employeeDetails);
	}
}
