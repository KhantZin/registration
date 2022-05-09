package com.kzw.sprintboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name", nullable=false)
	private @NonNull String firstName;
	
	@Column(name="last_name")
	private @NonNull String lastName;
	
	@Column(name="email")
	private @NonNull String email;
	
	
}
