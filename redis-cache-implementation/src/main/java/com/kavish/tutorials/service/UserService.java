package com.kavish.tutorials.service;

import com.kavish.tutorials.dto.UserDto;
import com.kavish.tutorials.response.UserResponse;
import com.kavish.tutorials.response.userdetailsresponse.UsersDetailsResponse;

import java.util.List;

public interface UserService {
    UsersDetailsResponse getUserDetails() throws Exception;

    UserResponse addUser(UserDto userDto) throws Exception;

    UserResponse getUser(Integer userId) throws Exception;

    void deleteUser(Integer userId) throws Exception;

    List<UserResponse> allUsers(Integer page) throws Exception;
}
