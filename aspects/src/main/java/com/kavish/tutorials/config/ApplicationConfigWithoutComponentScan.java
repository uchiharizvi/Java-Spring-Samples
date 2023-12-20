package com.kavish.tutorials.config;/*
package kavish.practice.springframeworkbasics.config;

import kavish.practice.springframeworkbasics.service.GreetingService;
import kavish.practice.springframeworkbasics.service.OutputService;
import kavish.practice.springframeworkbasics.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration //Specify this class as a config metadata to spring
@PropertySource("classpath:application.properties")//Explicitly define property file | Default : Application.properties
public class ApplicationConfigWithoutComponentScan {

    */
/*@Value("Hello")// Add value through annotation - coding standard
    private String greeting;*//*


    @Value("${app.greeting}") //Read value through property - coding standard
    private String greeting;

    @Value("${app.name}")//Read value through property - coding standard
    private String name;

    @Value("#{new Boolean(environment['spring.profiles.active']!='Dev')}")//Spring Spel -- Runtime execute the argument and store the result in is24 variable
    private boolean is24;

    @Autowired */
/*use @Autowired to let Spring handle Bean(Object) Creation*//*
 */
/***Field Injection is not recommended, why?***//*

    private GreetingService greetingService;

    @Autowired */
/*use @Autowired to let Spring handle Bean(Object) Creation*//*
 */
/***Field Injection is not recommended, why?***//*

    private TimeService timeService;

    @Bean //Bean Definition - Instantiate Bean Behaviour at the start of application
    public TimeService timeService() {
        return new TimeService(is24);
    }


    @Bean //Bean Definition - Instantiate Bean Behaviour at the start of application
    public GreetingService greetingService() {
        return new GreetingService(greeting);
    }

    @Bean //Bean Definition - Instantiate Bean Behaviour at the start of application
    public OutputService outputService() {
        return new OutputService(greetingService, timeService, name);
    }
}
*/
