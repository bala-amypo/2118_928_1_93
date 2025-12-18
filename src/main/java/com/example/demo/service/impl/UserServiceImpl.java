package com.example.demo.service.impl;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceIpl implements UserService{
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User register(Usrr user){
        return 
    }
}