package com.kzw.sprintboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kzw.sprintboot.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
