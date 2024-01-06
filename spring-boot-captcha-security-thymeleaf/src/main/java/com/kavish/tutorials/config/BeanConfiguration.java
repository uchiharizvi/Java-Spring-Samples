package com.kavish.tutorials.config;

import com.kavish.tutorials.controller.UserController;
import com.kavish.tutorials.repository.UserRepository;
import com.kavish.tutorials.repository.UserRepositoryImpl;
import com.kavish.tutorials.service.UserService;
import com.kavish.tutorials.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserServiceImpl(userRepository);
    }
    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryImpl();
    }
}
