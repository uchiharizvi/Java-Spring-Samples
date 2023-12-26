package com.kavish.tutorials.service;

import com.kavish.tutorials.entity.User;
import com.kavish.tutorials.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
public class UserServiceImpl implements UserService{
    @Autowired//TODO Check Auto wiring in detail
    private UserRepository repository;
    @Override
    public void createUser(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return repository.findById(id);
    }
}
