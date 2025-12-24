package com.example.demo.controller;


import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


private final UserService userService;
private final PasswordEncoder passwordEncoder;
private final JwtUtil jwtUtil;


public AuthController(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
this.userService = userService;
this.passwordEncoder = passwordEncoder;
this.jwtUtil = jwtUtil;
}


@PostMapping("/register")
public User register(@RequestBody RegisterRequest req) {
User user = new User(req.getName(), req.getEmail(), req.getPassword(), req.getRole());
return userService.registerUser(user);
}


@PostMapping("/login")
public String login(@RequestBody LoginRequest req) {
User user = userService.findByEmail(req.getEmail());
if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
throw new RuntimeException("Invalid credentials");
}
return jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
}
}