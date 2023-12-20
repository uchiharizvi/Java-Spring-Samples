package com.kavish.tutorials.controller;

import com.kavish.tutorials.dto.UserDto;
import com.kavish.tutorials.response.UserResponse;
import com.kavish.tutorials.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("add-user")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserDto userDto) throws Exception {
        UserResponse userResponse = userService.addUser(userDto);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer userId) throws Exception {
        UserResponse userResponse = userService.getUser(userId);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<UserResponse>> allUsers(@RequestParam(defaultValue = "1") Integer page) throws Exception {
        List<UserResponse> userResponses = userService.allUsers(page);
        return new ResponseEntity<List<UserResponse>>(userResponses, HttpStatus.OK);
    }

    @DeleteMapping("users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) throws Exception {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
}
