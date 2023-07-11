package com.javaeg.r2dbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("reactive_user")
@Data
public class User {
	@Id
	private Integer id;
	private String name;
	private String city;
	private String ssn;

}
