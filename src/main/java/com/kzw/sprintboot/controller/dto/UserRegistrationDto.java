package com.kzw.sprintboot.controller.dto;

import lombok.Data;

public @Data class UserRegistrationDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public UserRegistrationDto () {
		
	}
	
	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
}
