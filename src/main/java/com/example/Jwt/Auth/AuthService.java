package com.example.Jwt.Auth;

import org.springframework.stereotype.Service;

import com.example.Jwt.entity.Student;
import com.example.Jwt.jwt.JwtService;
import com.example.Jwt.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final StudentRepository studentRepository;
	private final JwtService jwtService;
	
	public AuthResponse login(LoginRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public AuthResponse register(RegisterRequest request) {
		Student student = Student.builder()
						.username(request.getUsername())
						.password(request.getPassword())
						.cursos(request.getCourses())
						.firstName(request.getFirstname())
						.lastName(request.getLastname())
						.country(request.getCountry())
						.role(request.getRole())
						.build();
		studentRepository.save(student);
		return AuthResponse.builder()
				.token(jwtService.getToken(student))
				.build();
	}

}
