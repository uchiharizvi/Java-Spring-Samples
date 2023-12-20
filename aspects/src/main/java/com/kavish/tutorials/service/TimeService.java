package com.kavish.tutorials.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service//Specify this class as service (special case of component) to be available for component scan - code standards
public class TimeService {

    private static final DateTimeFormatter FORMATTER_24 = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("hh:mm:ss a");

    @Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")//Spring Spel -- Runtime execute the argument and store the result in is24 variable
    private boolean is24; //Final??

    public TimeService() {
        super();
    }

    public String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        if(is24){
            return FORMATTER_24.format(now);
        }
        return FORMATTER_12.format(now);
    }
}
