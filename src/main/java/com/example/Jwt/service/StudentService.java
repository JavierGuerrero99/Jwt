package com.example.Jwt.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jwt.entity.Student;
import com.example.Jwt.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getStudents(){
		
		return studentRepository.findAll();
	}

	public Optional<Student> getStudent(Long id){		
		return studentRepository.findById(id);
	}
	
	//ResponseEntity cambiar y separar save de update, y retornar el status
	
	public void saveOrUpdate(Student student) {
		studentRepository.save(student);		
	}
	public void delete(Long id) {
		studentRepository.deleteById(id);		
	}
}
