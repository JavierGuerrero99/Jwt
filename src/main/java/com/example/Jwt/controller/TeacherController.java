package com.example.Jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jwt.entity.Teacher;
import com.example.Jwt.service.TeacherService;

@RestController
@RequestMapping(path="api/v1/teachers")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping
	public List<Teacher> getAll(){
		return teacherService.getTeachers();		
	}
	
	@PostMapping
	public void saveUpdate(@RequestBody Teacher teacher) {
		teacherService.saveOrUpdate(teacher);	
	}
	
	@DeleteMapping("/{teacherId}")
	public void delete(@PathVariable("teacherId")Long studentId){
		teacherService.delete(studentId);
	}
	
	@GetMapping("/{teacherId}")
	public Optional<Teacher> getById(@PathVariable("teacherId")Long teacherId){
		return teacherService.getTeacher(teacherId);
	}
}
