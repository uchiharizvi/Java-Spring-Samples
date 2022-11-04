package com.kavish.tutorials.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Value("${success.message}")
    public String message;
    @GetMapping("/data")
    public String getMessage(){
        return message;
    }
}
