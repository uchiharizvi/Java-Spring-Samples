package com.kavish.tutorials.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service//Specify this class as service (special case of component) to be available for component scan - code standards
public class GreetingService {

    @Value("${app.greeting}")
    private String greeting;

    //Constructor
    public GreetingService() {
        super();//What is this for?
        /*this.greeting = greeting;*/ //Not required if reading from properties
    }

    //Getter
    public String getGreeting(String name) {
        return greeting + " " + name;
    }
}
