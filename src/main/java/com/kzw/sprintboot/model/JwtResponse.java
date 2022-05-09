package com.kzw.sprintboot.model;

import java.io.Serializable;


public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 1708294529763757736L;
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	
}
