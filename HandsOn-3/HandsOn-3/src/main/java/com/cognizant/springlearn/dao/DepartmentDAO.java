package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.entity.Department;

public class DepartmentDAO {

	static ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
	static ArrayList<Department> DEPARTMENT_LIST = context.getBean("departmentList", java.util.ArrayList.class);

	public static ArrayList<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
}
