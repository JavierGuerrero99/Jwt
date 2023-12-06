package com.example.Jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jwt.entity.Teacher;
import com.example.Jwt.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepository;
	
	public List<Teacher> getTeachers(){
		return teacherRepository.findAll();		
	}
	public Optional<Teacher> getTeacher(Long id){
		return teacherRepository.findById(id);
	}
	
	public void saveOrUpdate(Teacher teacher){
		teacherRepository.save(teacher);
	}
	public void delete(Long id){
		teacherRepository.deleteById(id);
	}
}
