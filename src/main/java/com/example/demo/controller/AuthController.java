package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        // 🔥 FIX 1
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userService.findByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // 🔥 FIX 2
        String token = jwtUtil.generateToken(
                user.getEmail(),
                null,
                user.getRole()
        );

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("email", user.getEmail());
        response.put("role", user.getRole());

        return ResponseEntity.ok(response);
    }
}
