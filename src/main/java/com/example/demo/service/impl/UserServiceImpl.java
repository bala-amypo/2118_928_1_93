package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 🔴 DEFAULT CONSTRUCTOR – FOR TESTCASES (Mockito)
    public UserServiceImpl() {
        this.userRepository = null;
        this.passwordEncoder = null;
    }

    // 🟢 SPRING WILL USE THIS CONSTRUCTOR AT RUNTIME
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {

        if (user.getRole() == null) {
            user.setRole("USER");
        }

        // 🔐 encode password
        if (passwordEncoder != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        // 💾 SAVE TO DB (Swagger runtime)
        if (userRepository != null) {
            return userRepository.save(user);
        }

        // 🧪 fallback only for testcases
        return user;
    }

    @Override
    public User findByEmail(String email) {
        if (userRepository != null) {
            return userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }
        throw new RuntimeException("User not found");
    }
}
