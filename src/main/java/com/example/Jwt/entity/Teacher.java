package com.example.Jwt.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="tbl_teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long teacherId;

	private String firstName;
	
	private String lastName;
	
	@Column(name="email_address",unique= true, nullable=false)
	private String email;
}
