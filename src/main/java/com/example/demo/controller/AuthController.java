package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User userRequest) {
        User user = userService.findByEmail(userRequest.getEmail());

        // Verify password (assume simple equals for now)
        if (user != null && user.getPassword().equals(userRequest.getPassword())) {
            // Fixed: call generateToken correctly with a single String (email)
            String token = jwtUtil.generateToken(user.getEmail());
            return token;
        } else {
            return "Invalid credentials";
        }
    }
}
