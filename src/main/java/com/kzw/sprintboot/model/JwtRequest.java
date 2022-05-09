package com.kzw.sprintboot.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = -1760440365212569841L;
	
	
	private String username;
	private String password;

}
