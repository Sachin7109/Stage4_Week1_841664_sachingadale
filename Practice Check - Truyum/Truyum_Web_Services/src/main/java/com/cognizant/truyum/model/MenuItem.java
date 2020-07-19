package com.cognizant.truyum.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class MenuItem {

	@NotNull
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private float price;

	@NotNull
	private boolean active;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateOfLaunch;

	@NotNull
	private String category;

	@NotNull
	private boolean freeDelivery;

}
