package com.example.Jwt.Auth;

import java.util.List;

import com.example.Jwt.entity.Course;
import com.example.Jwt.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	String username;
	String password;
	String firstname;
	String lastname;
	String country;
	List<Course> courses;
	Role role;
	
}
