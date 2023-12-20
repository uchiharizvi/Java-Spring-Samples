package com.kavish.tutorials.service;

import com.kavish.tutorials.controller.AppController;
import com.kavish.tutorials.model.FacadeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class AppService {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOG = Logger.getLogger(AppController.class.getName());

    public FacadeResponse getService() throws Exception {

        FacadeResponse facadeResponse = new FacadeResponse();
        String Url = "http://httpbin.org/get";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);
        try {
            ResponseEntity<FacadeResponse> response = restTemplate.exchange(Url, HttpMethod.GET, requestEntity, FacadeResponse.class);
            facadeResponse = response.getBody();
            LOG.log(Level.INFO, "Service Response : " + response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Exception Occured" + e);
        }

        return facadeResponse;
    }
}
