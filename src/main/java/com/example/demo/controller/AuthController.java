// AuthController.java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService s) {
        this.service = s;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest r) {
        return service.registerUser(
            new User(r.name, r.email, r.password, r.role)
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest r) {
        service.findByEmail(r.email);
        return "LOGIN_SUCCESS";
    }
}
