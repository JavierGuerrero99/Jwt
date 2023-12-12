package com.example.Jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_course", uniqueConstraints = {@UniqueConstraint(columnNames= {"name"})})
public class Course{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long courseId;
	
	@Column(nullable =false) 
	private String name;
		
	public String getName() {
		return this.name;
	}	

}
	
