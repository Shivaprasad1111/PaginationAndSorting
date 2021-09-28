package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentPage;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public Page<Student> getStudents(StudentPage studentPage){
		Sort sort = Sort.by(studentPage.getSortDirection(), studentPage.getSortBy());
		PageRequest pageable = PageRequest.of(studentPage.getPageNumber(), 
				studentPage.getPageSize(), sort);
		return studentRepository.findAll(pageable);
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
}