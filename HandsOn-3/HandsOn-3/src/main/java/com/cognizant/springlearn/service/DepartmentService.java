package com.cognizant.springlearn.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.DepartmentDAO;
import com.cognizant.springlearn.entity.Department;

@Service
public class DepartmentService {

	@Transactional
	public static ArrayList<Department> getAllDepartments() {
		return DepartmentDAO.getAllDepartments();
	}
}
