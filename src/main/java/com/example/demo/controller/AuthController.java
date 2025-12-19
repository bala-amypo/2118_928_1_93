package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          AuthenticationManager authManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                req.getEmail(), req.getPassword()
            )
        );
        String token = jwtUtil.generateToken(req.getEmail());
        return new AuthResponse(token);
    }
}
