package com.cognizant.springlearn.entity;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.SpringLearnApplication;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Employee {

	@NotNull
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 25, message = "Name should be between 1 to 25 characters")
	private String name;

	@NotNull
	@Min(value = 0, message = "Salary must be 0 or above.")
	private double salary;

	@NotNull
	private String type;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateOfBirth;

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Employee() {
		LOGGER.info("Inside Employee Constructor");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", type=" + type + ", dateOfBirth="
				+ dateOfBirth + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
