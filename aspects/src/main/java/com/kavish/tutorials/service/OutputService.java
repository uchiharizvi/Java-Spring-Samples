package com.kavish.tutorials.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service//Specify this class as service (special case of component) to be available for component scan - code standards
public class OutputService {
    @Value("${app.name}")
    private String name; //PlaceHolder to store data received from constructor below

    private final GreetingService greetingService;//PlaceHolder to store data received from constructor below
    private final TimeService timeService;//PlaceHolder to store data received from constructor below

    //Constructor
    public OutputService(GreetingService greetingService, TimeService timeService) {
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    public void generateOutput(){
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }
}
