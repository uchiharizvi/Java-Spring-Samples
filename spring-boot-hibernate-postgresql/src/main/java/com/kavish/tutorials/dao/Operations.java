package com.kavish.tutorials.dao;


import com.kavish.tutorials.entity.UserInformation;

import java.util.List;

public interface Operations {
    List<UserInformation> getUsers() throws Exception;

    List<UserInformation> getUserDetail(Integer userId) throws Exception;

    String addUser(UserInformation userInformation) throws Exception;
}
