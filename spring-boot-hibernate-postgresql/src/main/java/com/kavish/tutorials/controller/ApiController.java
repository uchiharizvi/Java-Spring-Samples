package com.kavish.tutorials.controller;

import com.kavish.tutorials.dao.Operations;
import com.kavish.tutorials.entity.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private Operations crudOperation;

    @GetMapping("/v1/getusers")
    public List<UserInformation> getUsers() throws Exception {
        return crudOperation.getUsers();
    }

    @GetMapping("/v1/user/{userId}")
    public List<UserInformation> getUserDetail(@PathVariable Integer userId) throws Exception {
        return crudOperation.getUserDetail(userId);
    }

    @PostMapping("/v1/adduser")
    public String addUser(@RequestBody UserInformation userInformation) throws Exception {
        return crudOperation.addUser(userInformation);
    }

    @PutMapping("/v1/user/{userId}")
    public String updateUser() {
        return "Controller Created";
    }
}
