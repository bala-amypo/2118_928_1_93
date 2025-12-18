//ohm muruga
package com.example.demo.service;
import com.example.demo.entity.User;
public interface UserService{
    User register(User user);
    User findByEnail(String email);
}