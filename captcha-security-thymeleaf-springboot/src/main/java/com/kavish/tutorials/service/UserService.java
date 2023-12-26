package com.kavish.tutorials.service;

import com.kavish.tutorials.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUser(Integer id);
}
