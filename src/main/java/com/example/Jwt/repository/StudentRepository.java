package com.example.Jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Jwt.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	Optional<Student> findByUsername(String username);
}
