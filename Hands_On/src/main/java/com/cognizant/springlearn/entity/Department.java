package com.cognizant.springlearn.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.SpringLearnApplication;

@Component
public class Department {

	@NotNull
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 25, message = "Department name should be between 1 to 25 characters")
	private String name;

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Department() {
		LOGGER.info("Inside Department Constructor");
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
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

}
