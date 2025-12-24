package com.example.demo.util;


import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;


@Component
public class JwtUtil {


private final String secret = "secretkey";


public String generateToken(Long id, String email, String role) {
return Jwts.builder()
.setSubject(email)
.claim("userId", id)
.claim("role", role)
.setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis() + 86400000))
.signWith(SignatureAlgorithm.HS256, secret)
.compact();
}
}