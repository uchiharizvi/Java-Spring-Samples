package com.kavish.tutorials.controller;

import com.kavish.tutorials.response.userdetailsresponse.UsersDetailsResponse;
import com.kavish.tutorials.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @Autowired
    private UserService users;
    @GetMapping("/v1/getUsers")
    public UsersDetailsResponse getUserDetails() throws Exception {
        return users.getUserDetails();
    }
}
