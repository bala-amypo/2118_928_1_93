
package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User register(User user);

    String login(String email, String password);
}
