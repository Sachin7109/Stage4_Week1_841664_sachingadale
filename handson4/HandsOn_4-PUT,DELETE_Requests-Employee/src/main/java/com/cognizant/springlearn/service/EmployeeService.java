package com.cognizant.springlearn.service;

import java.util.ArrayList;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDAO;
import com.cognizant.springlearn.entity.Employee;

@Service
public class EmployeeService {

//	@Transactional
	public static ArrayList<Employee> getAllEmployees() {
		return EmployeeDAO.getAllEmployees();
	}

//	@Transactional
	public static Employee updateEmployee(int employeeId, Employee employeeDetails) throws EmployeeNotFoundException {
		return EmployeeDAO.updateEmployee(employeeId, employeeDetails);
	}

//	@Transactional
	public static Employee deleteEmployee(int employeeId, Employee employeeDetails) throws EmployeeNotFoundException {
		return EmployeeDAO.deleteEmployee(employeeId, employeeDetails);
	}
}
