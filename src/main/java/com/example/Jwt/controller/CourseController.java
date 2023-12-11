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

import com.example.Jwt.entity.Course;
import com.example.Jwt.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="api/v1/Courses")
@RequiredArgsConstructor
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> getAll(){
		return courseService.getCourses();		
	}
	
	@PostMapping
	public void saveUpdate(@RequestBody Course course) {
		courseService.saveOrUpdate(course);	
	}
	
	@DeleteMapping("/{CourseId}")
	public void delete(@PathVariable("CourseId")Long courseId){
		courseService.delete(courseId);
	}
	
	@GetMapping("/{CourseId}")
	public Optional<Course> getById(@PathVariable("courseId")Long courseId){
		return courseService.getCourse(courseId);
	}
}
