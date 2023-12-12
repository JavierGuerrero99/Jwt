package com.example.Jwt.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class corsGlobal {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/students")
				.allowedOrigins("http://localhost:8080")
				.allowedMethods("GET","POST","PUT","DELETE")
				.maxAge(3600);
				
			} 
		};
	}
}
	
