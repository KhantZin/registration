package com.kzw.sprintboot.service;

import java.util.List;

import com.kzw.sprintboot.model.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
	
	Long getTotalCount();
}
