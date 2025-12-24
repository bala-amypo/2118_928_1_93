package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User registerUser(User user) {
        // Dummy implementation: return the same user
        return user;
    }

    @Override
    public User findByEmail(String email) {
        // Dummy implementation: create a new user with given email
        User user = new User();
        user.setEmail(email);
        user.setName("Demo User");
        user.setPassword("password");
        user.setRole("USER");
        return user;
    }
}
