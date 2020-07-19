package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.entity.Employee;
import com.cognizant.springlearn.service.EmployeeNotFoundException;
import com.cognizant.springlearn.service.EmployeeService;

public class EmployeeDAO {

	static ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
	static ArrayList<Employee> EMPLOYEE_LIST = context.getBean("employeeList", java.util.ArrayList.class);

	public static ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public static Employee updateEmployee(int employeeId, Employee employeeDetails) throws EmployeeNotFoundException {

		// find employee to be updated using employeeId
		Employee employee = EMPLOYEE_LIST.stream().filter(emp -> emp.getId() == employeeId).findFirst()
				.orElseThrow(() -> new EmployeeNotFoundException());

		// update details of employee
		employee.setName(employeeDetails.getName());
		employee.setSalary(employeeDetails.getSalary());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setType(employeeDetails.getType());

		return employee;
	}

	public static Employee deleteEmployee(int employeeId, Employee employeeDetails) throws EmployeeNotFoundException {

		// find employee to be updated using employeeId
		Employee employee = EMPLOYEE_LIST.stream().filter(emp -> emp.getId() == employeeId).findFirst()
				.orElseThrow(() -> new EmployeeNotFoundException());

//		EMPLOYEE_LIST.remove(employee);
		
		return employee;

	}
}
