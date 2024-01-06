package com.kavish.tutorials.service;

import org.springframework.http.ResponseEntity;

public interface PaymentsService {
    public ResponseEntity<String> getCards() throws Exception;
    public ResponseEntity<String> addCards(String payload) throws Exception;
}
