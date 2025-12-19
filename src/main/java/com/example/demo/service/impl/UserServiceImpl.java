package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public User register(User user) {

        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Email already registered");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
