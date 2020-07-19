package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.entity.Employee;

public class EmployeeDAO {

	static ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
	static ArrayList<Employee> EMPLOYEE_LIST = context.getBean("employeeList", java.util.ArrayList.class);

	public static ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

}
