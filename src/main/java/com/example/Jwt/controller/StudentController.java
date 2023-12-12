package com.example.Jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jwt.entity.Student;
import com.example.Jwt.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="api/v1/students")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:8080")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/listar")
	public List<Student> getAll(){		
		 return studentService.getStudents();
	}
	
	@PostMapping()
	public void saveUpdate(@RequestBody Student student){		
		 studentService.saveOrUpdate(student);
	}
	
	@DeleteMapping("/{studentId}")
	public void delete(@PathVariable("studentId") Long studentId){		
		 studentService.delete(studentId);
	}
	
	@GetMapping("/{studentId}")
	public Optional<Student> getById(@PathVariable("studentId") Long studentId){		
		 return studentService.getStudent(studentId);
	}
	
	public String welcome() {
		return "Welcome form secure endpoint";
	}
	
}
