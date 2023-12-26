package com.kavish.tutorials.config;

import com.kavish.tutorials.aspects.LogResponseTimeAspect;
import com.kavish.tutorials.controller.PaymentsController;
import com.kavish.tutorials.service.PaymentsService;
import com.kavish.tutorials.service.PaymentsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {
    @Bean
    public LogResponseTimeAspect restLogAspect(){
        return new LogResponseTimeAspect();
    }
    @Bean
    public PaymentsService paymentsService(){
        return new PaymentsServiceImpl(restTemplate());
    }
    @Bean
    public PaymentsController paymentsController(){
        return new PaymentsController(paymentsService(),  restLogAspect());
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
