package com.kavish.tutorials.service;

import com.kavish.tutorials.dto.UserDto;
import com.kavish.tutorials.response.UserResponse;
import com.kavish.tutorials.response.userdetailsresponse.UsersDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate template;

    @Override
    @Cacheable(value = "itemCache")
    public UsersDetailsResponse getUserDetails() throws Exception {
        ResponseEntity<UsersDetailsResponse> response = template.exchange("https://reqres.in/api/users",
                HttpMethod.GET, getHttpEntity(), UsersDetailsResponse.class);
        return response.getBody();
    }

    @Override
    public UserResponse addUser(UserDto userDto) throws Exception {
        return null;
    }

    @Override
    public UserResponse getUser(Integer userId) throws Exception {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) throws Exception {

    }

    @Override
    public List<UserResponse> allUsers(Integer page) throws Exception {
        return null;
    }

    private HttpEntity<?> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<UsersDetailsResponse>(headers);
    }
}
