package com.cognizant.springlearn.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDAO;
import com.cognizant.springlearn.entity.Employee;

@Service
public class EmployeeService {

	@Transactional
	public static ArrayList<Employee> getAllEmployees() {
		return EmployeeDAO.getAllEmployees();
	}
}
