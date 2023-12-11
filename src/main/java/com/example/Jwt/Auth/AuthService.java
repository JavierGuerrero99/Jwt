package com.example.Jwt.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Jwt.entity.Role;
import com.example.Jwt.entity.Student;
import com.example.Jwt.jwt.JwtService;
import com.example.Jwt.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final StudentRepository studentRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
	
	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=studentRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
	}
	public AuthResponse register(RegisterRequest request) {
		Student student = Student.builder()
						.username(request.getUsername())
						.password(passwordEncoder.encode(request.getPassword()))
						.cursos(request.getCourses())
						.firstName(request.getFirstname())
						.lastName(request.getLastname())
						.country(request.getCountry())
						.role(Role.USER)
						.build();	
		studentRepository.save(student);
		return AuthResponse.builder()
				.token(jwtService.getToken(student))
				.build();
	}

}
