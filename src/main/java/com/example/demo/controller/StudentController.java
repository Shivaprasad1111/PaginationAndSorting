package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.StudentPage;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<Page<Student>> getStudents(StudentPage studentPage){
		return new ResponseEntity<>(studentService.getStudents(studentPage), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
	}
}
