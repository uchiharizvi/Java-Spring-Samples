package com.kavish.tutorials.config;

import com.kavish.tutorials.service.GreetingService;
import com.kavish.tutorials.service.OutputService;
import com.kavish.tutorials.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration //Specify this class as a config metadata to spring
@PropertySource("classpath:application.properties")//Explicitly define property file | Default : Application.properties
@ComponentScan(basePackages = "com.kavish.tutorials") //Not working-Reasons Unknown
@EnableAspectJAutoProxy
public class ApplicationConfig{

    @Autowired/*use @Autowired to let Spring handle Bean(Object) Creation*/ /***Field Injection is not recommended, why?***/
    private GreetingService greetingService;

    @Autowired/*use @Autowired to let Spring handle Bean(Object) Creation*/ /***Field Injection is not recommended, why?***/
    private TimeService timeService;

    @Bean //Bean Definition - Instantiate Bean Behaviour at the start of application
    public TimeService timeService() {
        return new TimeService();
    }


    @Bean //Bean Definition - Instantiate Bean Behaviour at the start of application
    public GreetingService greetingService() {
        return new GreetingService();
    }

    @Bean //Bean Definition - Instantiate Bean Behaviour at the start of application
    public OutputService outputService() {
        return new OutputService(greetingService, timeService);
    }
}
