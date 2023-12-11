package com.example.Jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jwt.entity.Course;
import com.example.Jwt.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	public List<Course> getCourses(){
		return courseRepository.findAll();		
	}
	public Optional<Course> getCourse(Long id){
		return courseRepository.findById(id);
	}
	
	public void saveOrUpdate(Course course){
		courseRepository.save(course);
	}
	public void delete(Long id){
		courseRepository.deleteById(id);
	}
}
