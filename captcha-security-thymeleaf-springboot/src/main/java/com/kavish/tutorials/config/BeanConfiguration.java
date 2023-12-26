package com.kavish.tutorials.config;

import com.kavish.tutorials.controller.UserController;
import com.kavish.tutorials.repository.UserRepository;
import com.kavish.tutorials.service.UserService;
import com.kavish.tutorials.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Autowired
    UserRepository repository;
    @Autowired
    UserService userService;
    @Bean
    public UserService userService(UserRepository userRepository){
        return userService;
    }
    @Bean
    public UserRepository userRepository(){
        return repository;
    }
}
