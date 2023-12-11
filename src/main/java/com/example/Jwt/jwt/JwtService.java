package com.example.Jwt.jwt;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	public static final String SECRET_KEY= "C294A4A4D21E0E7D7EAE10D7C780F9B3F59DC3F0CF9E18C3E59A688A5A823F4D";

	public String getToken(UserDetails student) {
 		
		return getToken(new HashMap<>(),student);
	}

	private String getToken(Map<String,Object> extraClaims, UserDetails student) {
		
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(student.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
				.signWith(getKey(),SignatureAlgorithm.HS256)
				.compact();
	}

	private Key getKey() {
		byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
