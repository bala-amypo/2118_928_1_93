package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.Map;

public interface UserService {

    User register(User user);

    Map<String, String> login(String email, String password);
}
