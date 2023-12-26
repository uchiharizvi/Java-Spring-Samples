package com.kavish.tutorials.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PaymentsServiceImpl implements PaymentsService {
    private static final Logger log = LoggerFactory.getLogger(PaymentsServiceImpl.class);
    private final RestTemplate template;
    @Value("${fake.api.host}")
    private String hostUrl;
    @Value("${fake.api.base}")
    private String baseUrl;
    @Value("${fake.api.listUsers}")
    private String listUsersAPI;
    @Value("${fake.api.createUser}")
    private String createUserAPI;

    public PaymentsServiceImpl(RestTemplate restTemplate) {
        this.template = restTemplate;
    }

    @Override
    public ResponseEntity<String> getCards() throws Exception {
        String endpoint = hostUrl + baseUrl + listUsersAPI;
        ResponseEntity<String> response = template.getForEntity(endpoint, String.class);
        //add json parser
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addCards(String payload) throws Exception {
        String endpoint = hostUrl + baseUrl + createUserAPI;
        ResponseEntity<String> response = template.exchange(endpoint, HttpMethod.POST,getPostEntity(payload),String.class, Optional.ofNullable(null));
        return new ResponseEntity<>(response.getBody(), HttpStatus.CREATED);
    }

    private HttpEntity<?> getPostEntity(String payload) {
        HttpHeaders header = new HttpHeaders();
        return new HttpEntity<String>(payload,header);
    }
}
