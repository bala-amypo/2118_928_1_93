package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    // ✅ REQUIRED BY TEST
    User register(User user);
}
